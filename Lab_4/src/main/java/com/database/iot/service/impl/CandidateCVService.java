package com.database.iot.service.impl;

import com.database.iot.DAO.DAO;
import com.database.iot.DAO.impl.CandidateCVDao;
import com.database.iot.model.CandidateCV;
import com.database.iot.service.Service;

import java.sql.SQLException;
import java.util.List;

public class CandidateCVService implements Service<CandidateCV> {
    private final DAO<CandidateCV> dao = new CandidateCVDao();

    @Override
    public List<CandidateCV> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public CandidateCV findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(CandidateCV candidateCV) throws SQLException {
        dao.create(candidateCV);
    }

    @Override
    public void update(Integer id, CandidateCV candidateCV) throws SQLException {
        dao.update(id, candidateCV);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
