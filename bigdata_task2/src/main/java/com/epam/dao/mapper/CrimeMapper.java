package com.epam.dao.mapper;

import com.epam.crime.entity.Crime;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class CrimeMapper implements RowMapper<Crime> {
    public static final String ID_COLUMN_LABEL = "id";
    private static final String CATEGORY_COLUMN_LABEL = "category";
    private static final String LOCATION_TYPE_COLUMN_LABEL = "location_type";
    private static final String LOCATION_ID_COLUMN_LABEL = "location_id";
    private static final String CONTEXT_COLUMN_LABEL = "context";
    private static final String OUTCOME_STATUS_COLUMN_LABEL = "outcome_status";
    private static final String PERSISTENT_ID_LABEL = "persistent_id";
    private static final String LOCATION_SUBTYPE_COLUMN_LABEL = "location_subtype";
    private static final String MONTH_COLUMN_LABEL = "month";

    @Override
    public Crime mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Crime crime = new Crime();

        int id = resultSet.getInt(ID_COLUMN_LABEL);
        crime.setId(id);

        String category = resultSet.getString(CATEGORY_COLUMN_LABEL);
        crime.setCategory(category);

        String locationType = resultSet.getString(LOCATION_TYPE_COLUMN_LABEL);
        crime.setLocationType(locationType);

        int locationId = resultSet.getInt(LOCATION_ID_COLUMN_LABEL);
        crime.setLocationId(locationId);

        String context = resultSet.getString(CONTEXT_COLUMN_LABEL);
        crime.setContext(context);

        String outcomeStatus = resultSet.getString(OUTCOME_STATUS_COLUMN_LABEL);
        crime.setOutcomeStatus(outcomeStatus);

        String persistentId = resultSet.getString(PERSISTENT_ID_LABEL);
        crime.setPersistentId(persistentId);

        String locationSubtype = resultSet.getString(LOCATION_SUBTYPE_COLUMN_LABEL);
        crime.setLocationSubtype(locationSubtype);

        String month = resultSet.getString(MONTH_COLUMN_LABEL);
        crime.setMonth(month);

        return crime;
    }
}
