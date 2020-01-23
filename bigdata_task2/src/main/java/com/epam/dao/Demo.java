package com.epam.dao;

import com.epam.config.DataSource;
import com.epam.entity.Street;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static List<Street> fetchData() {
        final String SQL_QUERY = "select * from street";
        List<Street> employees = null;
        try (Connection con = DataSource.getConnection();
             PreparedStatement pst = con.prepareStatement(SQL_QUERY);
             ResultSet rs = pst.executeQuery();) {
            employees = new ArrayList<Street>();
            Street employee;
            while (rs.next()) {
                employee = new Street();
                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));

                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public static void main(String[] args) {
        List<Street> list =fetchData();
        System.out.println(list.get(0));
    }
}
