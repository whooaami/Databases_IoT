package com.database.iot.controller.impl;

import com.database.iot.controller.Controller;
import com.database.iot.model.MarkOfInterview;
import com.database.iot.service.Service;
import com.database.iot.service.impl.MarkOfInterviewService;

import java.sql.SQLException;
import java.util.List;

public class MarkOfInterviewController implements Controller<MarkOfInterview> {
    private final Service<MarkOfInterview> service = new MarkOfInterviewService();

    @Override
    public List<MarkOfInterview> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public MarkOfInterview findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(MarkOfInterview markOfInterview) throws SQLException {
        service.create(markOfInterview);
    }

    @Override
    public void update(Integer id, MarkOfInterview markOfInterview) throws SQLException {
        service.update(id, markOfInterview);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
