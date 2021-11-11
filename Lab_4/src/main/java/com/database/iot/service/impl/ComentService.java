package com.database.iot.service.impl;

import com.database.iot.DAO.DAO;

import com.database.iot.DAO.impl.ComentDao;
import com.database.iot.model.Coment;
import com.database.iot.service.Service;

import java.sql.SQLException;
import java.util.List;

public class ComentService implements Service<Coment> {
    private final DAO<Coment> dao = new ComentDao();

    @Override
    public List<Coment> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Coment findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(Coment coment) throws SQLException {
        dao.create(coment);
    }

    @Override
    public void update(Integer id, Coment coment) throws SQLException {
        dao.update(id, coment);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
