package com.database.iot.controller.impl;

import com.database.iot.controller.Controller;
import com.database.iot.model.PotentialCandidate;
import com.database.iot.service.Service;
import com.database.iot.service.impl.PotentialCandidateService;

import java.sql.SQLException;
import java.util.List;

public class PotentialCandidateController implements Controller<PotentialCandidate> {
    private final Service<PotentialCandidate> service = new PotentialCandidateService();

    @Override
    public List<PotentialCandidate> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public PotentialCandidate findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(PotentialCandidate potentialCandidate) throws SQLException {
        service.create(potentialCandidate);
    }

    @Override
    public void update(Integer id, PotentialCandidate potentialCandidate) throws SQLException {
        service.update(id, potentialCandidate);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
