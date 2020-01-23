package com.epam.dao;

import com.epam.config.DataSource;
import com.epam.entity.Crime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//@Repository
public class CrimeDAO implements DAO<Crime>{
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
    private String category;
    private String locationType;
    private long locationId;
    private String context;
    private String persistentId;
    private String outcomeStatus;
    private String locationSubtype;
    private String month;
    private static final String INSERT_QUERY = "INSERT INTO crime (id, category, locationType, locationId, context,"
           + " persistentId, outcomeStatus, locationSubtype, month) VALUES (?,?,?,?,?,?,?,?,?)";

    public CrimeDAO() {
    }
@Override
    public boolean insert(Crime crime) throws DAOException {
//        return jdbcTemplate.update(INSERT_QUERY, crime.getId(), crime.getCategory(), crime.getLocationType(),
//                crime.getLocationId(), crime.getOutcomeStatus(), crime.getLocationSubtype(),
//                crime.getMonth()) > 0;
        boolean isSuccess = false;
        try (Connection con = DataSource.getConnection();
             PreparedStatement pst = con.prepareStatement(INSERT_QUERY);
        ) {
            pst.setInt(1, crime.getId());
            pst.setString(2, crime.getCategory());
            pst.setString(3, crime.getLocationType());
            pst.setInt(4, crime.getLocationId());
            pst.setString(5, crime.getContext());
            pst.setString(6, crime.getPersistentId());
            pst.setString(7, crime.getOutcomeStatus());
            pst.setString(8, crime.getLocationSubtype());
            pst.setString(9, crime.getMonth());
            int rs = pst.executeUpdate();
            if (rs > 0) {
                isSuccess = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
}
