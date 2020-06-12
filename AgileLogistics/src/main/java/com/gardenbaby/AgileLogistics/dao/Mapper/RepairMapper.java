package com.gardenbaby.AgileLogistics.dao.Mapper;

import java.util.List;

import com.gardenbaby.AgileLogistics.dao.dataobject.Repair;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface RepairMapper {
    @Delete({
        "delete from repair",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into repair (id, repairManID, ",
        "applyID, state, ",
        "assignTime, completeTime)",
        "values (#{id,jdbcType=INTEGER}, #{repairmanid,jdbcType=INTEGER}, ",
        "#{applyid,jdbcType=INTEGER}, #{state,jdbcType=INTEGER}, ",
        "#{assigntime,jdbcType=TIMESTAMP}, #{completetime,jdbcType=TIMESTAMP})"
    })
    int insert(Repair record);

    @Select({
        "select",
        "id, repairManID, applyID, state, assignTime, completeTime",
        "from repair",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="repairManID", property="repairmanid", jdbcType=JdbcType.INTEGER),
        @Result(column="applyID", property="applyid", jdbcType=JdbcType.INTEGER),
        @Result(column="state", property="state", jdbcType=JdbcType.INTEGER),
        @Result(column="assignTime", property="assigntime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="completeTime", property="completetime", jdbcType=JdbcType.TIMESTAMP)
    })
    Repair selectByPrimaryKey(Integer id);

    @Select({
        "select",
        "id, repairManID, applyID, state, assignTime, completeTime",
        "from repair"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="repairManID", property="repairmanid", jdbcType=JdbcType.INTEGER),
        @Result(column="applyID", property="applyid", jdbcType=JdbcType.INTEGER),
        @Result(column="state", property="state", jdbcType=JdbcType.INTEGER),
        @Result(column="assignTime", property="assigntime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="completeTime", property="completetime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Repair> selectAll();

    @Update({
        "update repair",
        "set repairManID = #{repairmanid,jdbcType=INTEGER},",
          "applyID = #{applyid,jdbcType=INTEGER},",
          "state = #{state,jdbcType=INTEGER},",
          "assignTime = #{assigntime,jdbcType=TIMESTAMP},",
          "completeTime = #{completetime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Repair record);
}