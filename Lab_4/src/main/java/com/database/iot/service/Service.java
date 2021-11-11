package com.database.iot.service;

import java.sql.SQLException;
import java.util.List;

public interface Service<T> {
    List<T> findAll() throws SQLException;

    default T findById(Integer id) throws SQLException {
        return null;
    }

    default void create(T entity) throws SQLException {
    }

    default void update(Integer id, T entity) throws SQLException {
    }

    default void delete(Integer id) throws SQLException {
    }

}
