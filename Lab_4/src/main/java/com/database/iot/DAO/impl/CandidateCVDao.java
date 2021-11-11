package com.database.iot.DAO.impl;

import com.database.iot.DAO.DAO;
import com.database.iot.model.CandidateCV;
import com.database.iot.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CandidateCVDao implements DAO<CandidateCV> {
    private static final String GET_ALL = "SELECT * FROM mydb.candidate_cv";
    private static final String GET_BY_ID = "SELECT * FROM mydb.candidate_cv WHERE id=?";
    private static final String CREATE = "" +
            "INSERT INTO mydb.candidate_cv " +
            "(job, work_experience, place_of_study, hobby, skills) VALUES (?,?,?,?,?);";
    private static final String UPDATE = "" +
            "UPDATE mydb.candidate_cv " +
            "SET `job` = ?, `work_experience` = ?, `place_of_study` = ?, `hobby` = ?, `skills` = ? WHERE (`id` = ?);";
    private static final String DELETE = "DELETE FROM mydb.candidate_cv WHERE (`id` = ?);";

    @Override
    public List<CandidateCV> findAll() throws SQLException {
        List<CandidateCV> candidateCVS = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                CandidateCV candidateCV = new CandidateCV(
                        resultSet.getInt("id"),
                        resultSet.getString("job"),
                        resultSet.getString("work_experience"),
                        resultSet.getString("place_of_study"),
                        resultSet.getString("hobby"),
                        resultSet.getString("skills"));
                candidateCVS.add(candidateCV);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return candidateCVS;
    }

    @Override
    public CandidateCV findById(Integer id) throws SQLException {
        CandidateCV candidateCV = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                candidateCV = new CandidateCV(
                        resultSet.getInt("id"),
                        resultSet.getString("job"),
                        resultSet.getString("work_experience"),
                        resultSet.getString("place_of_study"),
                        resultSet.getString("hobby"),
                        resultSet.getString("skills"));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return candidateCV;
    }

    @Override
    public void create(CandidateCV candidateCV) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, candidateCV.getJob());
            statement.setString(2, candidateCV.getWork_experience());
            statement.setString(3, candidateCV.getPlace_of_study());
            statement.setString(4, candidateCV.getHobby());
            statement.setString(5, candidateCV.getSkills());
            statement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, CandidateCV candidateCV) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, candidateCV.getJob());
            statement.setString(2, candidateCV.getWork_experience());
            statement.setString(3, candidateCV.getPlace_of_study());
            statement.setString(4, candidateCV.getHobby());
            statement.setString(5, candidateCV.getSkills());
            statement.setInt(6, candidateCV.getId());
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