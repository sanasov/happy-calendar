package ru.igrey.dev.dao;

import org.apache.ibatis.annotations.*;
import ru.igrey.dev.entity.event.CategoryEventEntity;

import java.util.List;

public interface CategoryEventDao {
    @Insert("INSERT INTO CATEGORY_EVENT (TITLE, DESCRIPTION) " +
            "VALUES (" +
            " #{title, jdbcType=VARCHAR}," +
            " #{description, jdbcType=VARCHAR}" +
            ")"
    )
    @Options(useGeneratedKeys = true, keyColumn = "id")
    void insert(CategoryEventEntity entity);


    @Update({"UPDATE CATEGORY_EVENT SET " +
            " TITLE = #{title, jdbcType=VARCHAR}," +
            " DESCRIPTION = #{description, jdbcType=VARCHAR} " +
            " WHERE ID = #{id, jdbcType=NUMERIC}"}
    )
    void update(CategoryEventEntity entity);

    @Select("SELECT * FROM CATEGORY_EVENT WHERE ID = #{id, jdbcType=NUMERIC}")
    @Results(id = "CategoryEventMap", value = {
            @Result(property = "id", column = "ID"),
            @Result(property = "title", column = "TITLE"),
            @Result(property = "description", column = "DESCRIPTION"),
            @Result(property = "events", javaType = List.class, column = "id", many = @Many(select = "ru.igrey.dev.dao.EventDao.selectByCategory"))
    })
    CategoryEventEntity select(Long id);

    @Select("SELECT * FROM CATEGORY_EVENT")
    @ResultMap("CategoryEventMap")
    List<CategoryEventEntity> selectAll();

}
