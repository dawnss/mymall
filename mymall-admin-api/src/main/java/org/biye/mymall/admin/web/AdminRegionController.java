package org.biye.mymall.admin.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.biye.mymall.admin.vo.RegionVo;
import org.biye.mymall.core.util.ResponseUtil;
import org.biye.mymall.db.domain.MymallRegion;
import org.biye.mymall.db.service.MymallRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin/region")
@Validated
public class AdminRegionController {
    private final Log logger = LogFactory.getLog(AdminRegionController.class);

    @Autowired
    private MymallRegionService regionService;

    @GetMapping("/list")
    public Object list() {
        List<RegionVo> regionVoList = new ArrayList<>();

        List<MymallRegion> mymallRegions = regionService.getAll();
        Map<Byte, List<MymallRegion>> collect = mymallRegions.stream().collect(Collectors.groupingBy(MymallRegion::getType));
        byte provinceType = 1 , cityType = 2 , areaType = 3;
        List<MymallRegion> provinceList = collect.get(provinceType);
        List<MymallRegion> city = collect.get(cityType);
        Map<Integer, List<MymallRegion>> cityListMap = city.stream().collect(Collectors.groupingBy(MymallRegion::getPid));
        List<MymallRegion> areas = collect.get(areaType);
        Map<Integer, List<MymallRegion>> areaListMap = areas.stream().collect(Collectors.groupingBy(MymallRegion::getPid));

        for (MymallRegion province : provinceList) {
            RegionVo provinceVO = new RegionVo(province.getId(),province.getName(),province.getCode(),province.getType());

            List<MymallRegion> cityList = cityListMap.get(province.getId());
            List<RegionVo> cityVOList = new ArrayList<>();
            for (MymallRegion cityVo : cityList) {
                RegionVo cityVO = new RegionVo(cityVo.getId(),cityVo.getName(),cityVo.getCode(),cityVo.getType());

                List<MymallRegion> areaList = areaListMap.get(cityVo.getId());
                List<RegionVo> areaVOList = new ArrayList<>();
                for (MymallRegion area : areaList) {
                    RegionVo areaVO = new RegionVo(area.getId(),area.getName(),area.getCode(),area.getType());
                    areaVOList.add(areaVO);
                }

                cityVO.setChildren(areaVOList);
                cityVOList.add(cityVO);
            }
            provinceVO.setChildren(cityVOList);
            regionVoList.add(provinceVO);
        }
        return ResponseUtil.okList(regionVoList);
    }
}
