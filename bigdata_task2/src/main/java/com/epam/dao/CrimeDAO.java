package com.epam.dao;

import com.epam.config.DataSource;
import com.epam.entity.Crime;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CrimeDAO implements DAO<Crime>{

    private static final String INSERT_QUERY = "INSERT INTO crime (id, category, location_type, location_id, context,"
           + " persistent_id, outcome_status_id, location_subtype, month) VALUES (?,?,?,?,?,?,?,?,?)";

    public CrimeDAO() {
    }
@Override
    public boolean insert(Crime crime) throws DAOException {
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
            pst.setInt(7, crime.getOutcomeStatusId());
            pst.setString(8, crime.getLocationSubtype());
            pst.setString(9, crime.getMonth());
            int rs = pst.executeUpdate();
            if (rs > 0) {
                isSuccess = true;
            }
        } catch (SQLException e) {
            throw new DAOException("Exception during outcome status insertion");
        }
        return isSuccess;
    }
}
