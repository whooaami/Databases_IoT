package com.database.iot.DAO.impl;

import com.database.iot.DAO.DAO;
import com.database.iot.model.Vacancy;
import com.database.iot.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VacancyDao implements DAO<Vacancy> {
    private static final String GET_ALL = "SELECT * FROM mydb.vacancy";
    private static final String GET_BY_ID = "SELECT * FROM mydb.vacancy WHERE id=?";
    private static final String CREATE = "" +
            "INSERT INTO mydb.vacancy " +
            "(job_desciption, project_name) VALUES (?,?);";
    private static final String UPDATE = "" +
            "UPDATE mydb.vacancy " +
            "SET `job_desciption` = ?, `project_name` = ? WHERE (`id` = ?);";
    private static final String DELETE = "DELETE FROM mydb.vacancy WHERE (`id` = ?);";

    @Override
    public List<Vacancy> findAll() throws SQLException {
        List<Vacancy> vacancies = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Vacancy vacancy = new Vacancy(
                        resultSet.getInt("id"),
                        resultSet.getString("job_desciption"),
                        resultSet.getString("project_name"));
                vacancies.add(vacancy);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return vacancies;
    }

    @Override
    public Vacancy findById(Integer id) throws SQLException {
        Vacancy vacancy = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                vacancy = new Vacancy(
                        resultSet.getInt("id"),
                        resultSet.getString("job_desciption"),
                        resultSet.getString("project_name"));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return vacancy;
    }

    @Override
    public void create(Vacancy vacancy) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, vacancy.getJob_desciption());
            statement.setString(2, vacancy.getProject_name());
            statement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Vacancy vacancy) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, vacancy.getJob_desciption());
            statement.setString(2, vacancy.getProject_name());
            statement.setInt(3, vacancy.getId());
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
