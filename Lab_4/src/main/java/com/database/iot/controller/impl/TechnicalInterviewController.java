package com.database.iot.controller.impl;

import com.database.iot.controller.Controller;
import com.database.iot.model.TechnicalInterview;
import com.database.iot.service.Service;
import com.database.iot.service.impl.TechnicalInterviewService;

import java.sql.SQLException;
import java.util.List;

public class TechnicalInterviewController implements Controller<TechnicalInterview> {
    private final Service<TechnicalInterview> service = new TechnicalInterviewService();

    @Override
    public List<TechnicalInterview> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public TechnicalInterview findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(TechnicalInterview technicalInterview) throws SQLException {
        service.create(technicalInterview);
    }

    @Override
    public void update(Integer id, TechnicalInterview technicalInterview) throws SQLException {
        service.update(id, technicalInterview);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
