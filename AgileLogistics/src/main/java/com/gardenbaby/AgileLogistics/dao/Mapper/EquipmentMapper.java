package com.gardenbaby.AgileLogistics.dao.Mapper;

import java.util.List;

import com.gardenbaby.AgileLogistics.dao.dataobject.Equipment;
import com.gardenbaby.AgileLogistics.tableobject.EquipmentReturn;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface EquipmentMapper {
    @Delete({
        "delete from equipment",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into equipment (id, name, ",
        "type, personLiable, ",
        "remarks, updateTime)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{type,jdbcType=VARCHAR}, #{personLiable,jdbcType=INTEGER}, ",
        "#{remarks,jdbcType=VARCHAR}, now())"
    })
    int insert(Equipment record);

    @Select({
        "select",
        "id, name, type, personLiable, remarks, updateTime",
        "from equipment",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="personLiable", property="personLiable", jdbcType=JdbcType.INTEGER),
        @Result(column="remarks", property="remarks", jdbcType=JdbcType.VARCHAR),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    Equipment selectByPrimaryKey(Integer id);

    @Select({
        "select",
        "id, name, type, personLiable, remarks, updateTime",
        "from equipment"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="personLiable", property="personLiable", jdbcType=JdbcType.INTEGER),
        @Result(column="remarks", property="remarks", jdbcType=JdbcType.VARCHAR),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Equipment> selectAll();

    @Update({
        "update equipment",
        "set name = #{name,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=VARCHAR},",
          "personLiable = #{personLiable,jdbcType=INTEGER},",
          "remarks = #{remarks,jdbcType=VARCHAR},",
          "updateTime = now()",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Equipment record);


    @Select({
            "select",
            "e.id, name, type, username, remarks, updateTime",
            "from equipment e left join users u on e.personLiable = u.id",
            "where  name like CONCAT('%', #{name,jdbcType=VARCHAR},'%') and type like CONCAT('%', #{type,jdbcType=VARCHAR},'%')"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
            @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
            @Result(column="username", property="personLiable", jdbcType=JdbcType.VARCHAR),
            @Result(column="remarks", property="remarks", jdbcType=JdbcType.VARCHAR),
            @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<EquipmentReturn> selectByNameAndType(String name, String type);
}