package org.biye.mymall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.biye.mymall.db.domain.MymallNoticeAdmin;
import org.biye.mymall.db.domain.MymallNoticeAdminExample;

public interface MymallNoticeAdminMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_notice_admin
     *
     * @mbg.generated
     */
    long countByExample(MymallNoticeAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_notice_admin
     *
     * @mbg.generated
     */
    int deleteByExample(MymallNoticeAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_notice_admin
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_notice_admin
     *
     * @mbg.generated
     */
    int insert(MymallNoticeAdmin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_notice_admin
     *
     * @mbg.generated
     */
    int insertSelective(MymallNoticeAdmin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_notice_admin
     *
     * @mbg.generated
     */
    MymallNoticeAdmin selectOneByExample(MymallNoticeAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_notice_admin
     *
     * @mbg.generated
     */
    MymallNoticeAdmin selectOneByExampleSelective(@Param("example") MymallNoticeAdminExample example, @Param("selective") MymallNoticeAdmin.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_notice_admin
     *
     * @mbg.generated
     */
    List<MymallNoticeAdmin> selectByExampleSelective(@Param("example") MymallNoticeAdminExample example, @Param("selective") MymallNoticeAdmin.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_notice_admin
     *
     * @mbg.generated
     */
    List<MymallNoticeAdmin> selectByExample(MymallNoticeAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_notice_admin
     *
     * @mbg.generated
     */
    MymallNoticeAdmin selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") MymallNoticeAdmin.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_notice_admin
     *
     * @mbg.generated
     */
    MymallNoticeAdmin selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_notice_admin
     *
     * @mbg.generated
     */
    MymallNoticeAdmin selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_notice_admin
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") MymallNoticeAdmin record, @Param("example") MymallNoticeAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_notice_admin
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") MymallNoticeAdmin record, @Param("example") MymallNoticeAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_notice_admin
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(MymallNoticeAdmin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_notice_admin
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(MymallNoticeAdmin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_notice_admin
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") MymallNoticeAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_notice_admin
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}