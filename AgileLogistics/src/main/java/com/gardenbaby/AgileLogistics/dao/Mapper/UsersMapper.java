package com.gardenbaby.AgileLogistics.dao.Mapper;

import java.util.List;

import com.gardenbaby.AgileLogistics.dao.dataobject.Users;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface UsersMapper {
    @Delete({
            "delete from users",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
            "insert into users (id, username, ",
            "pwd, power)",
            "values (#{id,jdbcType=INTEGER}, #{username,jdbcType=VARCHAR}, ",
            "#{pwd,jdbcType=VARCHAR}, #{power,jdbcType=INTEGER})"
    })
    int insert(Users record);

    @Select({
            "select",
            "id, username, pwd, power",
            "from users",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
            @Result(column="pwd", property="pwd", jdbcType=JdbcType.VARCHAR),
            @Result(column="power", property="power", jdbcType=JdbcType.INTEGER)
    })
    Users selectByPrimaryKey(Integer id);

    @Select({
            "select",
            "id, username, pwd, power",
            "from users"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
            @Result(column="pwd", property="pwd", jdbcType=JdbcType.VARCHAR),
            @Result(column="power", property="power", jdbcType=JdbcType.INTEGER)
    })
    List<Users> selectAll();

    @Update({
            "update users",
            "set username = #{username,jdbcType=VARCHAR},",
            "pwd = #{pwd,jdbcType=VARCHAR},",
            "power = #{power,jdbcType=INTEGER}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Users record);

    @Select({
            "select",
            "id, username, pwd, power",
            "from users",
            "where username = #{username,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
            @Result(column="pwd", property="pwd", jdbcType=JdbcType.VARCHAR),
            @Result(column="power", property="power", jdbcType=JdbcType.INTEGER)
    })
    Users slectOne(String username);
}