package org.linlinjava.litemall.admin.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.linlinjava.litemall.admin.vo.RegionVo;
import org.linlinjava.litemall.core.util.ResponseUtil;
import org.linlinjava.litemall.db.domain.LitemallRegion;
import org.linlinjava.litemall.db.service.LitemallRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
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
    private LitemallRegionService regionService;

    @GetMapping("/list")
    public Object list() {
        List<RegionVo> regionVoList = new ArrayList<>();

        List<LitemallRegion> litemallRegions = regionService.getAll();
        Map<Byte, List<LitemallRegion>> collect = litemallRegions.stream().collect(Collectors.groupingBy(LitemallRegion::getType));
        byte provinceType = 1 , cityType = 2 , areaType = 3;
        List<LitemallRegion> provinceList = collect.get(provinceType);
        List<LitemallRegion> city = collect.get(cityType);
        Map<Integer, List<LitemallRegion>> cityListMap = city.stream().collect(Collectors.groupingBy(LitemallRegion::getPid));
        List<LitemallRegion> areas = collect.get(areaType);
        Map<Integer, List<LitemallRegion>> areaListMap = areas.stream().collect(Collectors.groupingBy(LitemallRegion::getPid));

        for (LitemallRegion province : provinceList) {
            RegionVo provinceVO = new RegionVo(province.getId(),province.getName(),province.getCode(),province.getType());

            List<LitemallRegion> cityList = cityListMap.get(province.getId());
            List<RegionVo> cityVOList = new ArrayList<>();
            for (LitemallRegion cityVo : cityList) {
                RegionVo cityVO = new RegionVo(cityVo.getId(),cityVo.getName(),cityVo.getCode(),cityVo.getType());

                List<LitemallRegion> areaList = areaListMap.get(cityVo.getId());
                List<RegionVo> areaVOList = new ArrayList<>();
                for (LitemallRegion area : areaList) {
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
