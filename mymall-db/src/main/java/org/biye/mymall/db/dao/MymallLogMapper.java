package org.biye.mymall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.biye.mymall.db.domain.MymallLog;
import org.biye.mymall.db.domain.MymallLogExample;

public interface MymallLogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_log
     *
     * @mbg.generated
     */
    long countByExample(MymallLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_log
     *
     * @mbg.generated
     */
    int deleteByExample(MymallLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_log
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_log
     *
     * @mbg.generated
     */
    int insert(MymallLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_log
     *
     * @mbg.generated
     */
    int insertSelective(MymallLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_log
     *
     * @mbg.generated
     */
    MymallLog selectOneByExample(MymallLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_log
     *
     * @mbg.generated
     */
    MymallLog selectOneByExampleSelective(@Param("example") MymallLogExample example, @Param("selective") MymallLog.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_log
     *
     * @mbg.generated
     */
    List<MymallLog> selectByExampleSelective(@Param("example") MymallLogExample example, @Param("selective") MymallLog.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_log
     *
     * @mbg.generated
     */
    List<MymallLog> selectByExample(MymallLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_log
     *
     * @mbg.generated
     */
    MymallLog selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") MymallLog.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_log
     *
     * @mbg.generated
     */
    MymallLog selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_log
     *
     * @mbg.generated
     */
    MymallLog selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_log
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") MymallLog record, @Param("example") MymallLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_log
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") MymallLog record, @Param("example") MymallLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_log
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(MymallLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_log
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(MymallLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_log
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") MymallLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_log
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}