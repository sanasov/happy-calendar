package ru.igrey.dev.dao;

import org.apache.ibatis.annotations.*;
import ru.igrey.dev.entity.event.CategoryEventEntity;
import ru.igrey.dev.entity.event.EventEntity;

import java.util.List;

public interface CategoryEventDao {
    @Insert("INSERT INTO EVENT_CATEGORY (TITLE, DESCRIPTION, DATE_TIME) " +
            "VALUES (" +
            " #{title, jdbcType=VARCHAR}," +
            " #{description, jdbcType=VARCHAR}" +
            " #{dateTime, jdbcType=DATE}" +
            ")"
    )
    @Options(useGeneratedKeys = true, keyProperty = "ID", keyColumn = "ID")
    void insert(EventEntity entity);


    @Update({"UPDATE EVENT_CATEGORY SET " +
            " TITLE = #{title, jdbcType=VARCHAR}," +
            " DESCRIPTION = #{description, jdbcType=VARCHAR}, " +
            " CATEGORY_ID = #{categoryId, jdbcType=NUMERIC}" +
            " WHERE ID = #{id, jdbcType=NUMERIC}"}
    )
    void update(EventEntity entity);

    @Select("SELECT * FROM EVENT_CATEGORY WHERE ID = #{id, jdbcType=NUMERIC}")
    @Results(id = "CategoryEventMap", value = {
            @Result(property = "id", column = "ID"),
            @Result(property = "title", column = "TITLE"),
            @Result(property = "description", column = "DESCRIPTION"),
            @Result(property = "events", javaType = List.class, column = "id", many = @Many(select = "ru.igrey.dev.dao.EventDao.select"))
    })
    CategoryEventEntity select(Long id);

    @Select("SELECT * FROM EVENT_CATEGORY")
    @ResultMap("CategoryEventMap")
    List<CategoryEventEntity> selectAll();

}
