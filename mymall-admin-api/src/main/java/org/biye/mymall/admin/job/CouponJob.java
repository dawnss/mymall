package org.biye.mymall.admin.job;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.biye.mymall.db.domain.MymallCoupon;
import org.biye.mymall.db.domain.MymallCouponUser;
import org.biye.mymall.db.service.MymallCouponService;
import org.biye.mymall.db.service.MymallCouponUserService;
import org.biye.mymall.db.util.CouponConstant;
import org.biye.mymall.db.util.CouponUserConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 检测优惠券过期情况
 */
@Component
public class CouponJob {
    private final Log logger = LogFactory.getLog(CouponJob.class);

    @Autowired
    private MymallCouponService couponService;
    @Autowired
    private MymallCouponUserService couponUserService;

    /**
     * 每隔一个小时检查
     * TODO
     * 注意，因为是相隔一个小时检查，因此导致优惠券真正超时时间可能比设定时间延迟1个小时
     */
    @Scheduled(fixedDelay = 60 * 60 * 1000)
    public void checkCouponExpired() {
        logger.info("系统开启任务检查优惠券是否已经过期");

        List<MymallCoupon> couponList = couponService.queryExpired();
        for (MymallCoupon coupon : couponList) {
            coupon.setStatus(CouponConstant.STATUS_EXPIRED);
            couponService.updateById(coupon);
        }

        List<MymallCouponUser> couponUserList = couponUserService.queryExpired();
        for (MymallCouponUser couponUser : couponUserList) {
            couponUser.setStatus(CouponUserConstant.STATUS_EXPIRED);
            couponUserService.update(couponUser);
        }

        logger.info("系统结束任务检查优惠券是否已经过期");
    }

}
