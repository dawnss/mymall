package org.biye.mymall.core.system;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * 系统设置
 */
public class SystemConfig {
    // 小程序相关配置
    public final static String MYMALL_WX_INDEX_NEW = "mymall_wx_index_new";
    public final static String MYMALL_WX_INDEX_HOT = "mymall_wx_index_hot";
    public final static String MYMALL_WX_INDEX_BRAND = "mymall_wx_index_brand";
    public final static String MYMALL_WX_INDEX_TOPIC = "mymall_wx_index_topic";
    public final static String MYMALL_WX_INDEX_CATLOG_LIST = "mymall_wx_catlog_list";
    public final static String MYMALL_WX_INDEX_CATLOG_GOODS = "mymall_wx_catlog_goods";
    public final static String MYMALL_WX_SHARE = "mymall_wx_share";
    // 运费相关配置
    public final static String MYMALL_EXPRESS_FREIGHT_VALUE = "mymall_express_freight_value";
    public final static String MYMALL_EXPRESS_FREIGHT_MIN = "mymall_express_freight_min";
    // 订单相关配置
    public final static String MYMALL_ORDER_UNPAID = "mymall_order_unpaid";
    public final static String MYMALL_ORDER_UNCONFIRM = "mymall_order_unconfirm";
    public final static String MYMALL_ORDER_COMMENT = "mymall_order_comment";
    // 商场相关配置
    public final static String MYMALL_MALL_NAME = "mymall_mall_name";
    public final static String MYMALL_MALL_ADDRESS = "mymall_mall_address";
    public final static String MYMALL_MALL_PHONE = "mymall_mall_phone";
    public final static String MYMALL_MALL_QQ = "mymall_mall_qq";
    public final static String MYMALL_MALL_LONGITUDE = "mymall_mall_longitude";
    public final static String MYMALL_MALL_Latitude = "mymall_mall_latitude";

    //所有的配置均保存在该 HashMap 中
    private static Map<String, String> SYSTEM_CONFIGS = new HashMap<>();

    private static String getConfig(String keyName) {
        return SYSTEM_CONFIGS.get(keyName);
    }

    private static Integer getConfigInt(String keyName) {
        return Integer.parseInt(SYSTEM_CONFIGS.get(keyName));
    }

    private static Boolean getConfigBoolean(String keyName) {
        return Boolean.valueOf(SYSTEM_CONFIGS.get(keyName));
    }

    private static BigDecimal getConfigBigDec(String keyName) {
        return new BigDecimal(SYSTEM_CONFIGS.get(keyName));
    }

    public static Integer getNewLimit() {
        return getConfigInt(MYMALL_WX_INDEX_NEW);
    }

    public static Integer getHotLimit() {
        return getConfigInt(MYMALL_WX_INDEX_HOT);
    }

    public static Integer getBrandLimit() {
        return getConfigInt(MYMALL_WX_INDEX_BRAND);
    }

    public static Integer getTopicLimit() {
        return getConfigInt(MYMALL_WX_INDEX_TOPIC);
    }

    public static Integer getCatlogListLimit() {
        return getConfigInt(MYMALL_WX_INDEX_CATLOG_LIST);
    }

    public static Integer getCatlogMoreLimit() {
        return getConfigInt(MYMALL_WX_INDEX_CATLOG_GOODS);
    }

    public static boolean isAutoCreateShareImage() {
        return getConfigBoolean(MYMALL_WX_SHARE);
    }

    public static BigDecimal getFreight() {
        return getConfigBigDec(MYMALL_EXPRESS_FREIGHT_VALUE);
    }

    public static BigDecimal getFreightLimit() {
        return getConfigBigDec(MYMALL_EXPRESS_FREIGHT_MIN);
    }

    public static Integer getOrderUnpaid() {
        return getConfigInt(MYMALL_ORDER_UNPAID);
    }

    public static Integer getOrderUnconfirm() {
        return getConfigInt(MYMALL_ORDER_UNCONFIRM);
    }

    public static Integer getOrderComment() {
        return getConfigInt(MYMALL_ORDER_COMMENT);
    }

    public static String getMallName() {
        return getConfig(MYMALL_MALL_NAME);
    }

    public static String getMallAddress() {
        return getConfig(MYMALL_MALL_ADDRESS);
    }

    public static String getMallPhone() {
        return getConfig(MYMALL_MALL_PHONE);
    }

    public static String getMallQQ() {
        return getConfig(MYMALL_MALL_QQ);
    }

    public static String getMallLongitude() {
        return getConfig(MYMALL_MALL_LONGITUDE);
    }

    public static String getMallLatitude() {
        return getConfig(MYMALL_MALL_Latitude);
    }

    public static void setConfigs(Map<String, String> configs) {
        SYSTEM_CONFIGS = configs;
    }

    public static void updateConfigs(Map<String, String> data) {
        for (Map.Entry<String, String> entry : data.entrySet()) {
            SYSTEM_CONFIGS.put(entry.getKey(), entry.getValue());
        }
    }
}