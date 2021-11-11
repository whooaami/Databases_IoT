package com.database.iot.controller.impl;

import com.database.iot.controller.Controller;
import com.database.iot.model.Vacancy;
import com.database.iot.service.Service;
import com.database.iot.service.impl.VacancyService;

import java.sql.SQLException;
import java.util.List;

public class VacancyController implements Controller<Vacancy> {
    private final Service<Vacancy> service = new VacancyService();

    @Override
    public List<Vacancy> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public Vacancy findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(Vacancy vacancy) throws SQLException {
        service.create(vacancy);
    }

    @Override
    public void update(Integer id, Vacancy vacancy) throws SQLException {
        service.update(id, vacancy);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
