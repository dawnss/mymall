package org.biye.mymall.db.dao;

import org.apache.ibatis.annotations.Param;
import org.biye.mymall.db.domain.MymallOrder;
import org.biye.mymall.db.domain.OrderVo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface OrderMapper {
    int updateWithOptimisticLocker(@Param("lastUpdateTime") LocalDateTime lastUpdateTime, @Param("order") MymallOrder order);
    List<Map> getOrderIds(@Param("query") String query, @Param("orderByClause") String orderByClause);
    List<OrderVo> getOrderList(@Param("query") String query, @Param("orderByClause") String orderByClause);
}