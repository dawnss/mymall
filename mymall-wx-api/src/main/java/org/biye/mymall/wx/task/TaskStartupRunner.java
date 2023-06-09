package org.biye.mymall.wx.task;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.biye.mymall.core.system.SystemConfig;
import org.biye.mymall.core.task.TaskService;
import org.biye.mymall.db.domain.MymallOrder;
import org.biye.mymall.db.service.MymallOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Component
public class TaskStartupRunner implements ApplicationRunner {

    @Autowired
    private MymallOrderService orderService;
    @Autowired
    private TaskService taskService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<MymallOrder> orderList = orderService.queryUnpaid(SystemConfig.getOrderUnpaid());
        for(MymallOrder order : orderList){
            LocalDateTime add = order.getAddTime();
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime expire =  add.plusMinutes(SystemConfig.getOrderUnpaid());
            if(expire.isBefore(now)) {
                // 已经过期，则加入延迟队列
                taskService.addTask(new OrderUnpaidTask(order.getId(), 0));
            }
            else{
                // 还没过期，则加入延迟队列
                long delay = ChronoUnit.MILLIS.between(now, expire);
                taskService.addTask(new OrderUnpaidTask(order.getId(), delay));
            }
        }
    }
}