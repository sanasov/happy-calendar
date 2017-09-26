package ru.igrey.dev.dao.typehandler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.*;
import java.time.LocalDateTime;

@MappedTypes(LocalDateTime.class)
public class LocalDateTimeTypeHandler implements TypeHandler<LocalDateTime> {

    @Override
    public LocalDateTime getResult(ResultSet rs, String columnName) throws SQLException {
        if (rs.getTimestamp(columnName) == null) {
            return null;
        }
        return rs.getTimestamp(columnName).toLocalDateTime();
    }

    @Override
    public LocalDateTime getResult(ResultSet arg0, int arg1) throws SQLException {
        return null;
    }

    @Override
    public LocalDateTime getResult(CallableStatement arg0, int arg1) throws SQLException {
        return null;
    }

    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, LocalDateTime localDateTime, JdbcType jdbcType) throws SQLException {
        if(localDateTime != null) {
            preparedStatement.setTimestamp(i, Timestamp.valueOf(localDateTime));
        } else {preparedStatement.setTimestamp(i, null);}
    }
}

