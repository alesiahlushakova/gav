package com.epam.dao.mapper;

import com.epam.entity.Street;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StreetMapper implements RowMapper<Street> {
    public static final String ID_COLUMN_LABEL = "id";
    private static final String NAME_COLUMN_LABEL = "name";

    @Override
    public Street mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Street street = new Street();

        int id = resultSet.getInt(ID_COLUMN_LABEL);
        street.setId(id);

        String name = resultSet.getString(NAME_COLUMN_LABEL);
        street.setName(name);

        return street;
    }
}
