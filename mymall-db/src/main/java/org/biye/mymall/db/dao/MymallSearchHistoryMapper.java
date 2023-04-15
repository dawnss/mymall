package org.biye.mymall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.biye.mymall.db.domain.MymallSearchHistory;
import org.biye.mymall.db.domain.MymallSearchHistoryExample;

public interface MymallSearchHistoryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_search_history
     *
     * @mbg.generated
     */
    long countByExample(MymallSearchHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_search_history
     *
     * @mbg.generated
     */
    int deleteByExample(MymallSearchHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_search_history
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_search_history
     *
     * @mbg.generated
     */
    int insert(MymallSearchHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_search_history
     *
     * @mbg.generated
     */
    int insertSelective(MymallSearchHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_search_history
     *
     * @mbg.generated
     */
    MymallSearchHistory selectOneByExample(MymallSearchHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_search_history
     *
     * @mbg.generated
     */
    MymallSearchHistory selectOneByExampleSelective(@Param("example") MymallSearchHistoryExample example, @Param("selective") MymallSearchHistory.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_search_history
     *
     * @mbg.generated
     */
    List<MymallSearchHistory> selectByExampleSelective(@Param("example") MymallSearchHistoryExample example, @Param("selective") MymallSearchHistory.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_search_history
     *
     * @mbg.generated
     */
    List<MymallSearchHistory> selectByExample(MymallSearchHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_search_history
     *
     * @mbg.generated
     */
    MymallSearchHistory selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") MymallSearchHistory.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_search_history
     *
     * @mbg.generated
     */
    MymallSearchHistory selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_search_history
     *
     * @mbg.generated
     */
    MymallSearchHistory selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_search_history
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") MymallSearchHistory record, @Param("example") MymallSearchHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_search_history
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") MymallSearchHistory record, @Param("example") MymallSearchHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_search_history
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(MymallSearchHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_search_history
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(MymallSearchHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_search_history
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") MymallSearchHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_search_history
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}