package org.biye.mymall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.biye.mymall.db.domain.MymallFeedback;
import org.biye.mymall.db.domain.MymallFeedbackExample;

public interface MymallFeedbackMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_feedback
     *
     * @mbg.generated
     */
    long countByExample(MymallFeedbackExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_feedback
     *
     * @mbg.generated
     */
    int deleteByExample(MymallFeedbackExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_feedback
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_feedback
     *
     * @mbg.generated
     */
    int insert(MymallFeedback record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_feedback
     *
     * @mbg.generated
     */
    int insertSelective(MymallFeedback record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_feedback
     *
     * @mbg.generated
     */
    MymallFeedback selectOneByExample(MymallFeedbackExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_feedback
     *
     * @mbg.generated
     */
    MymallFeedback selectOneByExampleSelective(@Param("example") MymallFeedbackExample example, @Param("selective") MymallFeedback.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_feedback
     *
     * @mbg.generated
     */
    List<MymallFeedback> selectByExampleSelective(@Param("example") MymallFeedbackExample example, @Param("selective") MymallFeedback.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_feedback
     *
     * @mbg.generated
     */
    List<MymallFeedback> selectByExample(MymallFeedbackExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_feedback
     *
     * @mbg.generated
     */
    MymallFeedback selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") MymallFeedback.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_feedback
     *
     * @mbg.generated
     */
    MymallFeedback selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_feedback
     *
     * @mbg.generated
     */
    MymallFeedback selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_feedback
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") MymallFeedback record, @Param("example") MymallFeedbackExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_feedback
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") MymallFeedback record, @Param("example") MymallFeedbackExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_feedback
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(MymallFeedback record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_feedback
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(MymallFeedback record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_feedback
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") MymallFeedbackExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_feedback
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}