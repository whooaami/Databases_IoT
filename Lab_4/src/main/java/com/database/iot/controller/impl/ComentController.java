package com.database.iot.controller.impl;

import com.database.iot.controller.Controller;
import com.database.iot.model.Coment;
import com.database.iot.service.Service;
import com.database.iot.service.impl.ComentService;

import java.sql.SQLException;
import java.util.List;

public class ComentController implements Controller<Coment> {
    private final Service<Coment> service = new ComentService();

    @Override
    public List<Coment> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public Coment findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(Coment coment) throws SQLException {
        service.create(coment);
    }

    @Override
    public void update(Integer id, Coment coment) throws SQLException {
        service.update(id, coment);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
