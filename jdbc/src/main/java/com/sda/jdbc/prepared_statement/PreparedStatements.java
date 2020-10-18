package com.sda.jdbc.prepared_statement;

import com.sda.jdbc.statement.Statements;

import java.sql.*;
import java.util.logging.Logger;

public class PreparedStatements {

    //CRUD - create, read, update, delete
    private static final Logger logger = Logger.getLogger(Statements.class.getName());
    private static final String url = "jdbc:mysql://localhost:3306/jdbc_tutorial?serverTimezone=UTC";
    private static final String username = "root";
    private static final String password = "liliacului";

    //insert
    public void insertOperation(String name, String email, String country) {
        String sql = "INSERT INTO user(name, email, country) VALUES (?, ?, ?)";
        //try with resources
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            //set paratemeters to sql prepared statement
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, country);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.severe("failed to insert");
        }
    }

    //read
    public void queryOperation() {
        String sql = "SELECT * FROM user";

        //try with resources
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                //save properties from result set
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                logger.info(id + ", " + name + ", " + email + ", " + country);
            }
        } catch (SQLException e) {
            logger.severe("failed to insert");
        }
    }

    //update
    public void updateOperation(int id, String name, String email, String country) {
        String sql = "UPDATE user SET name = ?, email = ?, country = ? WHERE id = " + id;

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, country);
            logger.info("statement created " + preparedStatement);
            int affectedRows = preparedStatement.executeUpdate();
            logger.info("Update return: " + (affectedRows == 1 ? "OK" : "Error"));
        } catch (SQLException e) {
            logger.severe("failed to update");
        }
    }

    //delete
    public void deleteOperation(int id) {
        String sql = "DELETE FROM user WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            int affectedRows = preparedStatement.executeUpdate();
            logger.info("Delete return: " + (affectedRows == 1 ? "OK" : "Error"));
        } catch (SQLException e) {
            logger.severe("failed to delete");
        }
    }
}
