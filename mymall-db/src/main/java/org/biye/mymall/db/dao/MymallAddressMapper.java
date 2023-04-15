package org.biye.mymall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.biye.mymall.db.domain.MymallAddress;
import org.biye.mymall.db.domain.MymallAddressExample;

public interface MymallAddressMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_address
     *
     * @mbg.generated
     */
    long countByExample(MymallAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_address
     *
     * @mbg.generated
     */
    int deleteByExample(MymallAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_address
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_address
     *
     * @mbg.generated
     */
    int insert(MymallAddress record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_address
     *
     * @mbg.generated
     */
    int insertSelective(MymallAddress record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_address
     *
     * @mbg.generated
     */
    MymallAddress selectOneByExample(MymallAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_address
     *
     * @mbg.generated
     */
    MymallAddress selectOneByExampleSelective(@Param("example") MymallAddressExample example, @Param("selective") MymallAddress.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_address
     *
     * @mbg.generated
     */
    List<MymallAddress> selectByExampleSelective(@Param("example") MymallAddressExample example, @Param("selective") MymallAddress.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_address
     *
     * @mbg.generated
     */
    List<MymallAddress> selectByExample(MymallAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_address
     *
     * @mbg.generated
     */
    MymallAddress selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") MymallAddress.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_address
     *
     * @mbg.generated
     */
    MymallAddress selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_address
     *
     * @mbg.generated
     */
    MymallAddress selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_address
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") MymallAddress record, @Param("example") MymallAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_address
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") MymallAddress record, @Param("example") MymallAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_address
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(MymallAddress record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_address
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(MymallAddress record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_address
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") MymallAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_address
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}