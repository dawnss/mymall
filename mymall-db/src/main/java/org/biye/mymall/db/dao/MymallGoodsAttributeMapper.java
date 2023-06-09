package org.biye.mymall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.biye.mymall.db.domain.MymallGoodsAttribute;
import org.biye.mymall.db.domain.MymallGoodsAttributeExample;

public interface MymallGoodsAttributeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_goods_attribute
     *
     * @mbg.generated
     */
    long countByExample(MymallGoodsAttributeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_goods_attribute
     *
     * @mbg.generated
     */
    int deleteByExample(MymallGoodsAttributeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_goods_attribute
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_goods_attribute
     *
     * @mbg.generated
     */
    int insert(MymallGoodsAttribute record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_goods_attribute
     *
     * @mbg.generated
     */
    int insertSelective(MymallGoodsAttribute record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_goods_attribute
     *
     * @mbg.generated
     */
    MymallGoodsAttribute selectOneByExample(MymallGoodsAttributeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_goods_attribute
     *
     * @mbg.generated
     */
    MymallGoodsAttribute selectOneByExampleSelective(@Param("example") MymallGoodsAttributeExample example, @Param("selective") MymallGoodsAttribute.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_goods_attribute
     *
     * @mbg.generated
     */
    List<MymallGoodsAttribute> selectByExampleSelective(@Param("example") MymallGoodsAttributeExample example, @Param("selective") MymallGoodsAttribute.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_goods_attribute
     *
     * @mbg.generated
     */
    List<MymallGoodsAttribute> selectByExample(MymallGoodsAttributeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_goods_attribute
     *
     * @mbg.generated
     */
    MymallGoodsAttribute selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") MymallGoodsAttribute.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_goods_attribute
     *
     * @mbg.generated
     */
    MymallGoodsAttribute selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_goods_attribute
     *
     * @mbg.generated
     */
    MymallGoodsAttribute selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_goods_attribute
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") MymallGoodsAttribute record, @Param("example") MymallGoodsAttributeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_goods_attribute
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") MymallGoodsAttribute record, @Param("example") MymallGoodsAttributeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_goods_attribute
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(MymallGoodsAttribute record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_goods_attribute
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(MymallGoodsAttribute record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_goods_attribute
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") MymallGoodsAttributeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_goods_attribute
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}