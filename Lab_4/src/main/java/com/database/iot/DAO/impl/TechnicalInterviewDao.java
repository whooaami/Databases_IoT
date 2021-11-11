package com.database.iot.DAO.impl;

import com.database.iot.DAO.DAO;
import com.database.iot.model.EnglishInterview;
import com.database.iot.model.TechnicalInterview;
import com.database.iot.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TechnicalInterviewDao implements DAO<TechnicalInterview> {
    private static final String GET_ALL = "SELECT * FROM mydb.technical_interview";
    private static final String GET_BY_ID = "SELECT * FROM mydb.technical_interview WHERE id=?";
    private static final String CREATE = "" +
            "INSERT INTO mydb.technical_interview " +
            "(programming_language, algorithm, data_structure, database, result_interview) VALUES (?,?,?,?,?);";
    private static final String UPDATE = "" +
            "UPDATE mydb.technical_interview " +
            "SET `programming_language` = ?, `algorithm` = ?, `data_structure` = ?, `database` = ?," +
            " `result_interview` = ? WHERE (`id` = ?);";
    private static final String DELETE = "DELETE FROM mydb.technical_interview WHERE (`id` = ?);";

    @Override
    public List<TechnicalInterview> findAll() throws SQLException {
        List<TechnicalInterview> technicalInterviews = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                TechnicalInterview technicalInterview = new TechnicalInterview(
                        resultSet.getInt("id"),
                        resultSet.getString("programming_language"),
                        resultSet.getString("algorithm"),
                        resultSet.getString("data_structure"),
                        resultSet.getString("database"),
                        resultSet.getString("result_interview"));
                technicalInterviews.add(technicalInterview);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return technicalInterviews;
    }

    @Override
    public TechnicalInterview findById(Integer id) throws SQLException {
        TechnicalInterview technicalInterview = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                technicalInterview = new TechnicalInterview(
                        resultSet.getInt("id"),
                        resultSet.getString("programming_language"),
                        resultSet.getString("algorithm"),
                        resultSet.getString("data_structure"),
                        resultSet.getString("database"),
                        resultSet.getString("result_interview"));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return technicalInterview;
    }

    @Override
    public void create(TechnicalInterview technicalInterview) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, technicalInterview.getProgramming_language());
            statement.setString(2, technicalInterview.getAlgorithm());
            statement.setString(3, technicalInterview.getData_structure());
            statement.setString(4, technicalInterview.getDatabase());
            statement.setString(5, technicalInterview.getResult_interview());
            statement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, TechnicalInterview technicalInterview) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, technicalInterview.getProgramming_language());
            statement.setString(2, technicalInterview.getAlgorithm());
            statement.setString(3, technicalInterview.getData_structure());
            statement.setString(4, technicalInterview.getDatabase());
            statement.setString(5, technicalInterview.getResult_interview());
            statement.setInt(6, technicalInterview.getId());
            statement.executeUpdate();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(DELETE)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
