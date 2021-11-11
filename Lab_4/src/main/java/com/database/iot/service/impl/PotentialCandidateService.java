package com.database.iot.service.impl;

import com.database.iot.DAO.DAO;

import com.database.iot.DAO.impl.PotentialCandidateDao;
import com.database.iot.model.PotentialCandidate;
import com.database.iot.service.Service;

import java.sql.SQLException;
import java.util.List;

public class PotentialCandidateService implements Service<PotentialCandidate> {
    private final DAO<PotentialCandidate> dao = new PotentialCandidateDao();

    @Override
    public List<PotentialCandidate> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public PotentialCandidate findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(PotentialCandidate potentialCandidate) throws SQLException {
        dao.create(potentialCandidate);
    }

    @Override
    public void update(Integer id, PotentialCandidate potentialCandidate) throws SQLException {
        dao.update(id, potentialCandidate);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
