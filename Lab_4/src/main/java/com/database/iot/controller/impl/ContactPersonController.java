package com.database.iot.controller.impl;

import com.database.iot.controller.Controller;
import com.database.iot.model.ContactPerson;
import com.database.iot.service.Service;
import com.database.iot.service.impl.ContactPersonService;

import java.sql.SQLException;
import java.util.List;

public class ContactPersonController implements Controller<ContactPerson> {
    private final Service<ContactPerson> service = new ContactPersonService();

    @Override
    public List<ContactPerson> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public ContactPerson findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(ContactPerson contactPerson) throws SQLException {
        service.create(contactPerson);
    }

    @Override
    public void update(Integer id, ContactPerson contactPerson) throws SQLException {
        service.update(id, contactPerson);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
