package ru.igrey.dev.dao.typehandler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.*;
import java.time.LocalDate;

@MappedTypes(LocalDate.class)
public class LocalDateTypeHandler implements TypeHandler<LocalDate> {

    @Override
    public LocalDate getResult(ResultSet rs, String columnName) throws SQLException {
        if (rs.getDate(columnName) == null) {
            return null;
        }
        return rs.getDate(columnName).toLocalDate();
    }

    @Override
    public LocalDate getResult(ResultSet arg0, int arg1) throws SQLException {
        return null;
    }

    @Override
    public LocalDate getResult(CallableStatement arg0, int arg1) throws SQLException {
        return null;
    }

    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, LocalDate localDate, JdbcType jdbcType) throws SQLException {
        if(localDate != null) {
            preparedStatement.setDate(i, Date.valueOf(localDate));
        } else {preparedStatement.setDate(i, null);}
    }
}

