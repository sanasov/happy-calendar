package ru.igrey.dev.dao;

import org.apache.ibatis.annotations.*;
import ru.igrey.dev.domain.User;

import java.util.List;

public interface UserDao {
    @Insert("INSERT INTO HP_USER (LOGIN, PASSWORD, USER_NAME, USER_LAST_NAME, BIRTHDAY) " +
            "VALUES ( #{login, jdbcType=VARCHAR}," +
            " #{password, jdbcType=VARCHAR}," +
            " #{username, jdbcType=VARCHAR}," +
            " #{lastName, jdbcType=VARCHAR}," +
            " #{birthday, jdbcType=DATE})"
    )
    @Options(useGeneratedKeys = true, keyProperty = "ID", keyColumn = "ID")
    Long insert(User user);


    @Update("UPDATE HP_USER SET " +
            " LOGIN = #{login, jdbcType=VARCHAR}," +
            " PASSWORD =  #{password, jdbcType=VARCHAR}, " +
            " USER_NAME = #{username, jdbcType=VARCHAR}," +
            " USER_LAST_NAME =  #{lastName, jdbcType=VARCHAR}, " +
            " BIRTHDAY = #{birthday, jdbcType=DATE}," +
            " WHERE ID = #{id, jdbcType=NUMERIC}"
    )
    void update(User user);

    @Select("SELECT * FROM HP_USER WHERE ID = #{id, jdbcType=NUMERIC}")
    @Results(id = "UserMap", value = {
            @Result(property = "id", column = "ID"),
            @Result(property = "login", column = "LOGIN"),
            @Result(property = "password", column = "PASSWORD"),
            @Result(property = "username", column = "USER_NAME"),
            @Result(property = "lastName", column = "USER_LAST_NAME"),
            @Result(property = "roles", javaType = List.class, column = "id", many = @Many(select = "selectRolesByUserId"))
    })
    User selectById(Long id);

    @Select("SELECT * FROM HP_USER WHERE LOGIN = #{login, jdbcType=VARCHAR}")
    @ResultMap("UserMap")
    User selectByLogin(String login);

    @Select("SELECT r.ROLE_VALUE FROM ROLE AS r " +
            "LEFT JOIN MTM_HP_USER2ROLE AS mtm ON mtm.role_id = r.id " +
            "WHERE mtm.user_id = #{userId, jdbcType=NUMERIC}")
    List<String> selectRolesByUserId(Long userId);


}
