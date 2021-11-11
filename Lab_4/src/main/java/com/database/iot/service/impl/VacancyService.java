package com.database.iot.service.impl;

import com.database.iot.DAO.DAO;
import com.database.iot.DAO.impl.VacancyDao;
import com.database.iot.model.Vacancy;
import com.database.iot.service.Service;

import java.sql.SQLException;
import java.util.List;

public class VacancyService implements Service<Vacancy> {
    private final DAO<Vacancy> dao = new VacancyDao();

    @Override
    public List<Vacancy> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Vacancy findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(Vacancy vacancy) throws SQLException {
        dao.create(vacancy);
    }

    @Override
    public void update(Integer id, Vacancy vacancy) throws SQLException {
        dao.update(id, vacancy);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
