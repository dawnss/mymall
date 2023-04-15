package org.biye.mymall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.biye.mymall.db.domain.MymallOrderGoods;
import org.biye.mymall.db.domain.MymallOrderGoodsExample;

public interface MymallOrderGoodsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_order_goods
     *
     * @mbg.generated
     */
    long countByExample(MymallOrderGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_order_goods
     *
     * @mbg.generated
     */
    int deleteByExample(MymallOrderGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_order_goods
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_order_goods
     *
     * @mbg.generated
     */
    int insert(MymallOrderGoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_order_goods
     *
     * @mbg.generated
     */
    int insertSelective(MymallOrderGoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_order_goods
     *
     * @mbg.generated
     */
    MymallOrderGoods selectOneByExample(MymallOrderGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_order_goods
     *
     * @mbg.generated
     */
    MymallOrderGoods selectOneByExampleSelective(@Param("example") MymallOrderGoodsExample example, @Param("selective") MymallOrderGoods.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_order_goods
     *
     * @mbg.generated
     */
    List<MymallOrderGoods> selectByExampleSelective(@Param("example") MymallOrderGoodsExample example, @Param("selective") MymallOrderGoods.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_order_goods
     *
     * @mbg.generated
     */
    List<MymallOrderGoods> selectByExample(MymallOrderGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_order_goods
     *
     * @mbg.generated
     */
    MymallOrderGoods selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") MymallOrderGoods.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_order_goods
     *
     * @mbg.generated
     */
    MymallOrderGoods selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_order_goods
     *
     * @mbg.generated
     */
    MymallOrderGoods selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_order_goods
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") MymallOrderGoods record, @Param("example") MymallOrderGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_order_goods
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") MymallOrderGoods record, @Param("example") MymallOrderGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_order_goods
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(MymallOrderGoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_order_goods
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(MymallOrderGoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_order_goods
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") MymallOrderGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_order_goods
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}