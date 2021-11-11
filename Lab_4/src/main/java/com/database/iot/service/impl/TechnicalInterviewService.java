package com.database.iot.service.impl;

import com.database.iot.DAO.DAO;

import com.database.iot.DAO.impl.TechnicalInterviewDao;
import com.database.iot.model.TechnicalInterview;
import com.database.iot.service.Service;

import java.sql.SQLException;
import java.util.List;

public class TechnicalInterviewService implements Service<TechnicalInterview> {
    private final DAO<TechnicalInterview> dao = new TechnicalInterviewDao();

    @Override
    public List<TechnicalInterview> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public TechnicalInterview findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(TechnicalInterview technicalInterview) throws SQLException {
        dao.create(technicalInterview);
    }

    @Override
    public void update(Integer id, TechnicalInterview technicalInterview) throws SQLException {
        dao.update(id, technicalInterview);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
