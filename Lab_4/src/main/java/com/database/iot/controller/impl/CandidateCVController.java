package com.database.iot.controller.impl;

import com.database.iot.controller.Controller;
import com.database.iot.model.CandidateCV;
import com.database.iot.service.Service;
import com.database.iot.service.impl.CandidateCVService;

import java.sql.SQLException;
import java.util.List;
public class CandidateCVController implements Controller<CandidateCV> {

    private final Service<CandidateCV> service = new CandidateCVService();

    @Override
    public List<CandidateCV> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public CandidateCV findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(CandidateCV candidateCV) throws SQLException {
        service.create(candidateCV);
    }

    @Override
    public void update(Integer id, CandidateCV candidateCV) throws SQLException {
        service.update(id, candidateCV);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
