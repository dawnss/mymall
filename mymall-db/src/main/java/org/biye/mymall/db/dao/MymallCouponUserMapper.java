package org.biye.mymall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.biye.mymall.db.domain.MymallCouponUser;
import org.biye.mymall.db.domain.MymallCouponUserExample;

public interface MymallCouponUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_coupon_user
     *
     * @mbg.generated
     */
    long countByExample(MymallCouponUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_coupon_user
     *
     * @mbg.generated
     */
    int deleteByExample(MymallCouponUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_coupon_user
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_coupon_user
     *
     * @mbg.generated
     */
    int insert(MymallCouponUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_coupon_user
     *
     * @mbg.generated
     */
    int insertSelective(MymallCouponUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_coupon_user
     *
     * @mbg.generated
     */
    MymallCouponUser selectOneByExample(MymallCouponUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_coupon_user
     *
     * @mbg.generated
     */
    MymallCouponUser selectOneByExampleSelective(@Param("example") MymallCouponUserExample example, @Param("selective") MymallCouponUser.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_coupon_user
     *
     * @mbg.generated
     */
    List<MymallCouponUser> selectByExampleSelective(@Param("example") MymallCouponUserExample example, @Param("selective") MymallCouponUser.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_coupon_user
     *
     * @mbg.generated
     */
    List<MymallCouponUser> selectByExample(MymallCouponUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_coupon_user
     *
     * @mbg.generated
     */
    MymallCouponUser selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") MymallCouponUser.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_coupon_user
     *
     * @mbg.generated
     */
    MymallCouponUser selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_coupon_user
     *
     * @mbg.generated
     */
    MymallCouponUser selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_coupon_user
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") MymallCouponUser record, @Param("example") MymallCouponUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_coupon_user
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") MymallCouponUser record, @Param("example") MymallCouponUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_coupon_user
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(MymallCouponUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_coupon_user
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(MymallCouponUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_coupon_user
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") MymallCouponUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_coupon_user
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}