package org.biye.mymall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.biye.mymall.db.domain.MymallCoupon;
import org.biye.mymall.db.domain.MymallCouponExample;

public interface MymallCouponMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_coupon
     *
     * @mbg.generated
     */
    long countByExample(MymallCouponExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_coupon
     *
     * @mbg.generated
     */
    int deleteByExample(MymallCouponExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_coupon
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_coupon
     *
     * @mbg.generated
     */
    int insert(MymallCoupon record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_coupon
     *
     * @mbg.generated
     */
    int insertSelective(MymallCoupon record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_coupon
     *
     * @mbg.generated
     */
    MymallCoupon selectOneByExample(MymallCouponExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_coupon
     *
     * @mbg.generated
     */
    MymallCoupon selectOneByExampleSelective(@Param("example") MymallCouponExample example, @Param("selective") MymallCoupon.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_coupon
     *
     * @mbg.generated
     */
    List<MymallCoupon> selectByExampleSelective(@Param("example") MymallCouponExample example, @Param("selective") MymallCoupon.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_coupon
     *
     * @mbg.generated
     */
    List<MymallCoupon> selectByExample(MymallCouponExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_coupon
     *
     * @mbg.generated
     */
    MymallCoupon selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") MymallCoupon.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_coupon
     *
     * @mbg.generated
     */
    MymallCoupon selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_coupon
     *
     * @mbg.generated
     */
    MymallCoupon selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_coupon
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") MymallCoupon record, @Param("example") MymallCouponExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_coupon
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") MymallCoupon record, @Param("example") MymallCouponExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_coupon
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(MymallCoupon record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_coupon
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(MymallCoupon record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_coupon
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") MymallCouponExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_coupon
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}