package com.database.iot.DAO.impl;

import com.database.iot.DAO.DAO;
import com.database.iot.model.MarkOfInterview;
import com.database.iot.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MarkOfInterviewDao implements DAO<MarkOfInterview> {
    private static final String GET_ALL = "SELECT * FROM mydb.mark_of_interview";
    private static final String GET_BY_ID = "SELECT * FROM mydb.mark_of_interview WHERE id=?";
    private static final String CREATE = "" +
            "INSERT INTO mydb.mark_of_interview (level , coment_id) VALUES (?,?);";
    private static final String UPDATE = "" +
            "UPDATE mydb.mark_of_interview " +
            "SET `level` = ?, `coment_id` = ? WHERE (`id` = ?);";
    private static final String DELETE = "DELETE FROM mydb.mark_of_interview WHERE (`id` = ?);";

    @Override
    public List<MarkOfInterview> findAll() throws SQLException {
        List<MarkOfInterview> markOfInterviews = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                MarkOfInterview markOfInterview = new MarkOfInterview(
                        resultSet.getInt("id"),
                        resultSet.getString("level"),
                        resultSet.getInt("coment_id"));
                markOfInterviews.add(markOfInterview);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return markOfInterviews;
    }

    @Override
    public MarkOfInterview findById(Integer id) throws SQLException {
        MarkOfInterview markOfInterview = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                markOfInterview = new MarkOfInterview(
                        resultSet.getInt("id"),
                        resultSet.getString("level"),
                        resultSet.getInt("coment_id"));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return markOfInterview;
    }

    @Override
    public void create(MarkOfInterview markOfInterview) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, markOfInterview.getLevel());
            statement.setInt(2, markOfInterview.getComent_id());
            statement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, MarkOfInterview markOfInterview) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, markOfInterview.getLevel());
            statement.setInt(2, markOfInterview.getComent_id());
            statement.setInt(3, markOfInterview.getId());
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
