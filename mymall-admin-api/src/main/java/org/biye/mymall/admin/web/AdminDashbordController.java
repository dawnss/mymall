package org.biye.mymall.admin.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.biye.mymall.core.util.ResponseUtil;
import org.biye.mymall.db.service.MymallGoodsProductService;
import org.biye.mymall.db.service.MymallGoodsService;
import org.biye.mymall.db.service.MymallOrderService;
import org.biye.mymall.db.service.MymallUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin/dashboard")
@Validated
public class AdminDashbordController {
    private final Log logger = LogFactory.getLog(AdminDashbordController.class);

    @Autowired
    private MymallUserService userService;
    @Autowired
    private MymallGoodsService goodsService;
    @Autowired
    private MymallGoodsProductService productService;
    @Autowired
    private MymallOrderService orderService;

    @GetMapping("")
    public Object info() {
        int userTotal = userService.count();
        int goodsTotal = goodsService.count();
        int productTotal = productService.count();
        int orderTotal = orderService.count();
        Map<String, Integer> data = new HashMap<>();
        data.put("userTotal", userTotal);
        data.put("goodsTotal", goodsTotal);
        data.put("productTotal", productTotal);
        data.put("orderTotal", orderTotal);

        return ResponseUtil.ok(data);
    }

}
