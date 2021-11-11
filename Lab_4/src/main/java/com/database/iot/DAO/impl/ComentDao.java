package com.database.iot.DAO.impl;

import com.database.iot.DAO.DAO;
import com.database.iot.model.Coment;
import com.database.iot.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComentDao implements DAO<Coment> {
    private static final String GET_ALL = "SELECT * FROM mydb.coment";
    private static final String GET_BY_ID = "SELECT * FROM mydb.coment WHERE id=?";
    private static final String CREATE = "" +
            "INSERT INTO mydb.coment (rating, response) VALUES (?,?);";
    private static final String UPDATE = "" +
            "UPDATE mydb.coment " +
            "SET `rating` = ?, `response` = ? WHERE (`id` = ?);";
    private static final String DELETE = "DELETE FROM mydb.coment WHERE (`id` = ?);";

    @Override
    public List<Coment> findAll() throws SQLException {
        List<Coment> coments = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Coment coment = new Coment(
                        resultSet.getInt("id"),
                        resultSet.getString("rating"),
                        resultSet.getString("response"));
                coments.add(coment);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return coments;
    }

    @Override
    public Coment findById(Integer id) throws SQLException {
        Coment coment = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                coment = new Coment(
                        resultSet.getInt("id"),
                        resultSet.getString("rating"),
                        resultSet.getString("response"));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return coment;
    }

    @Override
    public void create(Coment coment) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, coment.getRating());
            statement.setString(2, coment.getResponse());
            statement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Coment coment) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, coment.getRating());
            statement.setString(2, coment.getResponse());
            statement.setInt(3, coment.getId());
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
