package org.biye.mymall.admin.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.biye.mymall.admin.annotation.RequiresPermissionsDesc;
import org.biye.mymall.core.util.ResponseUtil;
import org.biye.mymall.core.validator.Order;
import org.biye.mymall.core.validator.Sort;
import org.biye.mymall.db.domain.MymallFootprint;
import org.biye.mymall.db.service.MymallFootprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/footprint")
@Validated
public class AdminFootprintController {
    private final Log logger = LogFactory.getLog(AdminFootprintController.class);

    @Autowired
    private MymallFootprintService footprintService;

    @RequiresPermissions("admin:footprint:list")
    @RequiresPermissionsDesc(menu = {"用户管理", "用户足迹"}, button = "查询")
    @GetMapping("/list")
    public Object list(String userId, String goodsId,
                       @RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer limit,
                       @Sort @RequestParam(defaultValue = "add_time") String sort,
                       @Order @RequestParam(defaultValue = "desc") String order) {
        List<MymallFootprint> footprintList = footprintService.querySelective(userId, goodsId, page, limit, sort,
                order);
        return ResponseUtil.okList(footprintList);
    }
}
