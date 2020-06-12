package com.gardenbaby.AgileLogistics.dao.Mapper;

import java.util.List;

import com.gardenbaby.AgileLogistics.dao.dataobject.Apply;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface ApplyMapper {
    @Delete({
            "delete from apply",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
            "insert into apply (id, applyOrderID, ",
            "applyManID, applyRegionID, ",
            "applyDescribe, pictureURL, ",
            "address, applyTime, ",
            "applyremarks)",
            "values (#{id,jdbcType=INTEGER}, #{applyorderid,jdbcType=VARCHAR}, ",
            "#{applymanid,jdbcType=INTEGER}, #{applyregionid,jdbcType=INTEGER}, ",
            "#{applydescribe,jdbcType=VARCHAR}, #{pictureurl,jdbcType=VARCHAR}, ",
            "#{address,jdbcType=VARCHAR}, #{applytime,jdbcType=TIMESTAMP}, ",
            "#{applyremarks,jdbcType=VARCHAR})"
    })
    int insert(Apply record);

    @Select({
            "select",
            "id, applyOrderID, applyManID, applyRegionID, applyDescribe, pictureURL, address, ",
            "applyTime, applyremarks",
            "from apply",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="applyOrderID", property="applyorderid", jdbcType=JdbcType.VARCHAR),
            @Result(column="applyManID", property="applymanid", jdbcType=JdbcType.INTEGER),
            @Result(column="applyRegionID", property="applyregionid", jdbcType=JdbcType.INTEGER),
            @Result(column="applyDescribe", property="applydescribe", jdbcType=JdbcType.VARCHAR),
            @Result(column="pictureURL", property="pictureurl", jdbcType=JdbcType.VARCHAR),
            @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
            @Result(column="applyTime", property="applytime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="applyremarks", property="applyremarks", jdbcType=JdbcType.VARCHAR)
    })
    Apply selectByPrimaryKey(Integer id);

    @Select({
            "select",
            "id, applyOrderID, applyManID, applyRegionID, applyDescribe, pictureURL, address, ",
            "applyTime, applyremarks",
            "from apply"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="applyOrderID", property="applyorderid", jdbcType=JdbcType.VARCHAR),
            @Result(column="applyManID", property="applymanid", jdbcType=JdbcType.INTEGER),
            @Result(column="applyRegionID", property="applyregionid", jdbcType=JdbcType.INTEGER),
            @Result(column="applyDescribe", property="applydescribe", jdbcType=JdbcType.VARCHAR),
            @Result(column="pictureURL", property="pictureurl", jdbcType=JdbcType.VARCHAR),
            @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
            @Result(column="applyTime", property="applytime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="applyremarks", property="applyremarks", jdbcType=JdbcType.VARCHAR)
    })
    List<Apply> selectAll();

    @Update({
            "update apply",
            "set applyOrderID = #{applyorderid,jdbcType=VARCHAR},",
            "applyManID = #{applymanid,jdbcType=INTEGER},",
            "applyRegionID = #{applyregionid,jdbcType=INTEGER},",
            "applyDescribe = #{applydescribe,jdbcType=VARCHAR},",
            "pictureURL = #{pictureurl,jdbcType=VARCHAR},",
            "address = #{address,jdbcType=VARCHAR},",
            "applyTime = #{applytime,jdbcType=TIMESTAMP},",
            "applyremarks = #{applyremarks,jdbcType=VARCHAR}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Apply record);
}