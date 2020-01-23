package com.epam.dao.mapper;

import com.epam.crime.entity.Location;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LocationMapper implements RowMapper<Location> {
    private static final String ID_COLUMN_LABEL = "id";
    private static final String LATITUDE_COLUMN_LABEL = "latitude";
    private static final String LONGITUDE_COLUMN_LABEL = "longitude";
    private static final String STREET_ID_COLUMN_LABEL = "street_id";

@Override
    public Location mapRow(ResultSet resultSet, int rowNum) throws SQLException {
    Location location = new Location();

    int id = resultSet.getInt(ID_COLUMN_LABEL);
    location.setId(id);

    float latitude = resultSet.getFloat(LATITUDE_COLUMN_LABEL);
    location.setLatitude(latitude);

    float longitude = resultSet.getFloat(LONGITUDE_COLUMN_LABEL);
    location.setLongitude(longitude);

    long streetId = resultSet.getInt(STREET_ID_COLUMN_LABEL);
    location.setStreetId(streetId);

    return location;
}
}
