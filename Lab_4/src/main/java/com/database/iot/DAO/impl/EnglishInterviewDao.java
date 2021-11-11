package com.database.iot.DAO.impl;

import com.database.iot.DAO.DAO;
import com.database.iot.model.EnglishInterview;
import com.database.iot.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnglishInterviewDao implements DAO<EnglishInterview> {
    private static final String GET_ALL = "SELECT * FROM mydb.english_interview";
    private static final String GET_BY_ID = "SELECT * FROM mydb.english_interview WHERE id=?";
    private static final String CREATE = "" +
            "INSERT INTO mydb.english_interview " +
            "(level_of_technical, level_of_speaking, general_level) VALUES (?,?,?);";
    private static final String UPDATE = "" +
            "UPDATE mydb.english_interview " +
            "SET `level_of_technical` = ?, `level_of_speaking` = ?, `general_level` = ? WHERE (`id` = ?);";
    private static final String DELETE = "DELETE FROM mydb.english_interview WHERE (`id` = ?);";

    @Override
    public List<EnglishInterview> findAll() throws SQLException {
        List<EnglishInterview> englishInterviews = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                EnglishInterview englishInterview = new EnglishInterview(
                        resultSet.getInt("id"),
                        resultSet.getString("level_of_technical"),
                        resultSet.getString("level_of_speaking"),
                        resultSet.getString("general_level"));
                englishInterviews.add(englishInterview);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return englishInterviews;
    }

    @Override
    public EnglishInterview findById(Integer id) throws SQLException {
        EnglishInterview englishInterview = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                englishInterview = new EnglishInterview(
                        resultSet.getInt("id"),
                        resultSet.getString("level_of_technical"),
                        resultSet.getString("level_of_speaking"),
                        resultSet.getString("general_level"));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return englishInterview;
    }

    @Override
    public void create(EnglishInterview englishInterview) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, englishInterview.getLevel_of_technical());
            statement.setString(2, englishInterview.getLevel_of_speaking());
            statement.setString(3, englishInterview.getGeneral_level());
            statement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, EnglishInterview englishInterview) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, englishInterview.getLevel_of_technical());
            statement.setString(2, englishInterview.getLevel_of_speaking());
            statement.setString(3, englishInterview.getGeneral_level());
            statement.setInt(4, englishInterview.getId());
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
