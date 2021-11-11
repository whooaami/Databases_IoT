package com.database.iot.controller.impl;

import com.database.iot.controller.Controller;
import com.database.iot.model.EnglishInterview;
import com.database.iot.service.Service;
import com.database.iot.service.impl.EnglishInterviewService;

import java.sql.SQLException;
import java.util.List;
public class EnglishInterviewController implements Controller<EnglishInterview> {

    private final Service<EnglishInterview> service = new EnglishInterviewService();

    @Override
    public List<EnglishInterview> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public EnglishInterview findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(EnglishInterview englishInterview) throws SQLException {
        service.create(englishInterview);
    }

    @Override
    public void update(Integer id, EnglishInterview englishInterview) throws SQLException {
        service.update(id, englishInterview);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
