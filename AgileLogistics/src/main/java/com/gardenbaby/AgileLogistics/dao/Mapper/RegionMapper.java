package com.gardenbaby.AgileLogistics.dao.Mapper;

import java.util.List;

import com.gardenbaby.AgileLogistics.dao.dataobject.Region;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface RegionMapper {
    @Delete({
        "delete from region",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into region (id, building, ",
        "floor)",
        "values (#{id,jdbcType=INTEGER}, #{building,jdbcType=VARCHAR}, ",
        "#{floor,jdbcType=VARCHAR})"
    })
    int insert(Region record);

    @Select({
        "select",
        "id, building, floor",
        "from region",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="building", property="building", jdbcType=JdbcType.VARCHAR),
        @Result(column="floor", property="floor", jdbcType=JdbcType.VARCHAR)
    })
    Region selectByPrimaryKey(Integer id);

    @Select({
        "select",
        "id, building, floor",
        "from region"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="building", property="building", jdbcType=JdbcType.VARCHAR),
        @Result(column="floor", property="floor", jdbcType=JdbcType.VARCHAR)
    })
    List<Region> selectAll();

    @Update({
        "update region",
        "set building = #{building,jdbcType=VARCHAR},",
          "floor = #{floor,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Region record);


    @Select({
            "select",
            "id, building, floor",
            "from region",
            "where building like CONCAT('%',#{building,jdbcType=VARCHAR},'%')"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="building", property="building", jdbcType=JdbcType.VARCHAR),
            @Result(column="floor", property="floor", jdbcType=JdbcType.VARCHAR)
    })
    List<Region> selectByBuilding(String building);
}