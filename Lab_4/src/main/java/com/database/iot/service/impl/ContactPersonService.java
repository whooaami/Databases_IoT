package com.database.iot.service.impl;

import com.database.iot.DAO.DAO;
import com.database.iot.DAO.impl.ContactPersonDao;
import com.database.iot.model.ContactPerson;
import com.database.iot.service.Service;

import java.sql.SQLException;
import java.util.List;

public class ContactPersonService implements Service<ContactPerson> {
    private final DAO<ContactPerson> dao = new ContactPersonDao();

    @Override
    public List<ContactPerson> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public ContactPerson findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(ContactPerson contactPerson) throws SQLException {
        dao.create(contactPerson);
    }

    @Override
    public void update(Integer id, ContactPerson contactPerson) throws SQLException {
        dao.update(id, contactPerson);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
