package com.database.iot.service.impl;

import com.database.iot.DAO.DAO;

import com.database.iot.DAO.impl.MarkOfInterviewDao;
import com.database.iot.model.MarkOfInterview;
import com.database.iot.service.Service;

import java.sql.SQLException;
import java.util.List;

public class MarkOfInterviewService implements Service<MarkOfInterview> {
    private final DAO<MarkOfInterview> dao = new MarkOfInterviewDao();

    @Override
    public List<MarkOfInterview> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public MarkOfInterview findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(MarkOfInterview markOfInterview) throws SQLException {
        dao.create(markOfInterview);
    }

    @Override
    public void update(Integer id, MarkOfInterview markOfInterview) throws SQLException {
        dao.update(id, markOfInterview);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
