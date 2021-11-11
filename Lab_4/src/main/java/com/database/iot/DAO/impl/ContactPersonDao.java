package com.database.iot.DAO.impl;

import com.database.iot.DAO.DAO;
import com.database.iot.model.ContactPerson;
import com.database.iot.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContactPersonDao implements DAO<ContactPerson> {
    private static final String GET_ALL = "SELECT * FROM mydb.contact_person";
    private static final String GET_BY_ID = "SELECT * FROM mydb.contact_person WHERE id=?";
    private static final String CREATE = "" +
            "INSERT INTO mydb.contact_person " +
            "(name, surname, phone_number) VALUES (?,?,?);";
    private static final String UPDATE = "" +
            "UPDATE mydb.contact_person " +
            "SET `name` = ?, `surname` = ?, `phone_number` = ? WHERE (`id` = ?);";
    private static final String DELETE = "DELETE FROM mydb.contact_person WHERE (`id` = ?);";

    @Override
    public List<ContactPerson> findAll() throws SQLException {
        List<ContactPerson> contactPersons = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ContactPerson contactPerson = new ContactPerson(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getInt("phone_number"));
                contactPersons.add(contactPerson);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return contactPersons;
    }

    @Override
    public ContactPerson findById(Integer id) throws SQLException {
        ContactPerson contactPerson = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                contactPerson = new ContactPerson(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getInt("phone_number"));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return contactPerson;
    }

    @Override
    public void create(ContactPerson contactPerson) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, contactPerson.getName());
            statement.setString(2, contactPerson.getSurname());
            statement.setInt(3, contactPerson.getPhone_number());
            statement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, ContactPerson contactPerson) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, contactPerson.getName());
            statement.setString(2, contactPerson.getSurname());
            statement.setInt(3, contactPerson.getPhone_number());
            statement.setInt(4, contactPerson.getId());
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
