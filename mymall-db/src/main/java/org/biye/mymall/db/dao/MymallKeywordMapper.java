package org.biye.mymall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.biye.mymall.db.domain.MymallKeyword;
import org.biye.mymall.db.domain.MymallKeywordExample;

public interface MymallKeywordMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_keyword
     *
     * @mbg.generated
     */
    long countByExample(MymallKeywordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_keyword
     *
     * @mbg.generated
     */
    int deleteByExample(MymallKeywordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_keyword
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_keyword
     *
     * @mbg.generated
     */
    int insert(MymallKeyword record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_keyword
     *
     * @mbg.generated
     */
    int insertSelective(MymallKeyword record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_keyword
     *
     * @mbg.generated
     */
    MymallKeyword selectOneByExample(MymallKeywordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_keyword
     *
     * @mbg.generated
     */
    MymallKeyword selectOneByExampleSelective(@Param("example") MymallKeywordExample example, @Param("selective") MymallKeyword.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_keyword
     *
     * @mbg.generated
     */
    List<MymallKeyword> selectByExampleSelective(@Param("example") MymallKeywordExample example, @Param("selective") MymallKeyword.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_keyword
     *
     * @mbg.generated
     */
    List<MymallKeyword> selectByExample(MymallKeywordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_keyword
     *
     * @mbg.generated
     */
    MymallKeyword selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") MymallKeyword.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_keyword
     *
     * @mbg.generated
     */
    MymallKeyword selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_keyword
     *
     * @mbg.generated
     */
    MymallKeyword selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_keyword
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") MymallKeyword record, @Param("example") MymallKeywordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_keyword
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") MymallKeyword record, @Param("example") MymallKeywordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_keyword
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(MymallKeyword record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_keyword
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(MymallKeyword record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_keyword
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") MymallKeywordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mymall_keyword
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}