package ru.igrey.dev.dao;

import org.apache.ibatis.annotations.*;
import ru.igrey.dev.entity.event.EventEntity;

public interface EventDao {
    @Insert("INSERT INTO hp.EVENT (TITLE, DESCRIPTION, CATEGORY_ID, DATE_TIME) " +
            "VALUES (" +
            " #{title, jdbcType=VARCHAR}," +
            " #{description, jdbcType=VARCHAR}," +
            " #{categoryId, jdbcType=NUMERIC}," +
            " #{dateTime, jdbcType=TIMESTAMP }" +
            ")"
    )
    @Options(useGeneratedKeys = true, keyProperty = "ID", keyColumn = "ID")
    void insert(EventEntity entity);


    @Update({"UPDATE hp.EVENT SET " +
            " TITLE = #{title, jdbcType=VARCHAR}," +
            " DESCRIPTION = #{description, jdbcType=VARCHAR}, " +
            " CATEGORY_ID = #{categoryId, jdbcType=NUMERIC}, " +
            " DATE_TIME =  #{dateTime, jdbcType=TIMESTAMP } " +
            " WHERE ID = #{id, jdbcType=NUMERIC}"}
    )
    void update(EventEntity entity);

    @Select("SELECT * FROM hp.EVENT WHERE ID = #{id, jdbcType=NUMERIC}")
    @Results(id = "EventMap", value = {
            @Result(property = "id", column = "ID"),
            @Result(property = "title", column = "TITLE"),
            @Result(property = "description", column = "DESCRIPTION"),
            @Result(property = "dateTime", column = "DATE_TIME")
    })
    EventEntity select(Long id);
}
