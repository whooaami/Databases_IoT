package com.database.iot.service.impl;

import com.database.iot.DAO.DAO;
import com.database.iot.DAO.impl.EnglishInterviewDao;
import com.database.iot.model.EnglishInterview;
import com.database.iot.service.Service;

import java.sql.SQLException;
import java.util.List;

public class EnglishInterviewService implements Service<EnglishInterview> {
    private final DAO<EnglishInterview> dao = new EnglishInterviewDao();

    @Override
    public List<EnglishInterview> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public EnglishInterview findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(EnglishInterview englishInterview) throws SQLException {
        dao.create(englishInterview);
    }

    @Override
    public void update(Integer id, EnglishInterview englishInterview) throws SQLException {
        dao.update(id, englishInterview);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
