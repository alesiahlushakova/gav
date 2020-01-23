package com.epam.dao;

import com.epam.config.DataSource;
import com.epam.entity.Location;
import com.epam.entity.Street;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//@Repository
public class LocationDAO implements DAO<Location>{
//    @Autowired
//    private JdbcTemplate jdbcTemplate;

    private static final String INSERT_QUERY = "INSERT INTO location (id, latitude, longitude, street_id) VALUES (?,?,?,?)";

    public LocationDAO() {
    }

@Override
    public boolean insert(Location location) throws DAOException {
//        return jdbcTemplate.update(INSERT_QUERY, location.getId(), location.getLatitude(), location.getLongitude(),
//                location.getStreetId()) > 0;
        boolean isSuccess = false;
        try (Connection con = DataSource.getConnection();
             PreparedStatement pst = con.prepareStatement(INSERT_QUERY);
           ) {
            pst.setInt(1, location.getId());
            pst.setFloat(2, location.getLatitude());
            pst.setFloat(3, location.getLongitude());
            pst.setInt(4, location.getStreetId());
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
