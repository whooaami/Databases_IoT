package com.database.iot.DAO.impl;

import com.database.iot.DAO.DAO;
import com.database.iot.model.PotentialCandidate;
import com.database.iot.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PotentialCandidateDao implements DAO<PotentialCandidate> {
    private static final String GET_ALL = "SELECT * FROM mydb.potential_candidate";
    private static final String GET_BY_ID = "SELECT * FROM mydb.potential_candidate WHERE id=?";
    private static final String CREATE = "" +
            "INSERT INTO mydb.potential_candidate (name , surname, phone_number, email, github, linkedin," +
            "candidate_cv_id, english_interview_id, technical_interview_id, mark_of_interview_id) VALUES (?,?,?,?,?," +
            "?,?,?,?,?);";
    private static final String UPDATE = "" +
            "UPDATE mydb.potential_candidate " +
            "SET `name` = ?, `surname` = ?, `phone_number` = ?, `email` = ?, `github` = ?, `linkedin` = ?," +
            " `candidate_cv_id` = ?, `english_interview_id` = ?, `technical_interview_id` = ?," +
            " `mark_of_interview_id` = ? WHERE (`id` = ?);";
    private static final String DELETE = "DELETE FROM mydb.potential_candidate WHERE (`id` = ?);";

    @Override
    public List<PotentialCandidate> findAll() throws SQLException {
        List<PotentialCandidate> potentialCandidates = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                PotentialCandidate potentialCandidate = new PotentialCandidate(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getInt("phone_number"),
                        resultSet.getString("email"),
                        resultSet.getString("github"),
                        resultSet.getString("linkedin"),
                        resultSet.getInt("candidate_cv_id"),
                        resultSet.getInt("english_interview_id"),
                        resultSet.getInt("technical_interview_id"),
                        resultSet.getInt("mark_of_interview_id"));
                potentialCandidates.add(potentialCandidate);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return potentialCandidates;
    }

    @Override
    public PotentialCandidate findById(Integer id) throws SQLException {
        PotentialCandidate potentialCandidate = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                potentialCandidate = new PotentialCandidate(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getInt("phone_number"),
                        resultSet.getString("email"),
                        resultSet.getString("github"),
                        resultSet.getString("linkedin"),
                        resultSet.getInt("candidate_cv_id"),
                        resultSet.getInt("english_interview_id"),
                        resultSet.getInt("technical_interview_id"),
                        resultSet.getInt("mark_of_interview_id"));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return potentialCandidate;
    }

    @Override
    public void create(PotentialCandidate potentialCandidate) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, potentialCandidate.getName());
            statement.setString(2, potentialCandidate.getSurname());
            statement.setInt(3, potentialCandidate.getPhone_number());
            statement.setString(4, potentialCandidate.getEmail());
            statement.setString(5, potentialCandidate.getGithub());
            statement.setString(6, potentialCandidate.getLinkedin());
            statement.setInt(7, potentialCandidate.getCandidate_cv_id());
            statement.setInt(8, potentialCandidate.getEnglish_interview_id());
            statement.setInt(9, potentialCandidate.getTechnical_interview_id());
            statement.setInt(10, potentialCandidate.getMark_of_interview_id());
            statement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, PotentialCandidate potentialCandidate) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, potentialCandidate.getName());
            statement.setString(2, potentialCandidate.getSurname());
            statement.setInt(3, potentialCandidate.getPhone_number());
            statement.setString(4, potentialCandidate.getEmail());
            statement.setString(5, potentialCandidate.getGithub());
            statement.setString(6, potentialCandidate.getLinkedin());
            statement.setInt(7, potentialCandidate.getCandidate_cv_id());
            statement.setInt(8, potentialCandidate.getEnglish_interview_id());
            statement.setInt(9, potentialCandidate.getTechnical_interview_id());
            statement.setInt(10, potentialCandidate.getMark_of_interview_id());
            statement.setInt(11, potentialCandidate.getId());
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
