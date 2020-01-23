package com.epam.dao;

import com.epam.config.DataSource;
import com.epam.entity.Location;
import com.epam.entity.Street;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//@Repository
public class StreetDAO implements DAO<Street> {
//    @Autowired
//    private JdbcTemplate jdbcTemplate;

    private static final String INSERT_QUERY = "INSERT INTO street (id, name) VALUES (?,?)";

    public StreetDAO() {
    }
@Override
    public boolean insert(Street street) throws DAOException {
       // return jdbcTemplate.update(INSERT_QUERY, street.getId(), street.getName()) > 0;
            boolean isSuccess = false;
            try (Connection con = DataSource.getConnection();
                 PreparedStatement pst = con.prepareStatement(INSERT_QUERY);
            ) {
                pst.setInt(1, street.getId());
                pst.setString(2, street.getName());
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
