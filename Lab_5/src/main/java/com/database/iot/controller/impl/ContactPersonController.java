package com.database.iot.controller.impl;

import com.database.iot.model.dao.impl.AbstractGenericDaoImpl;
import com.database.iot.model.dao.impl.ContactPersonDaoImpl;
import com.database.iot.model.entities.ContactPerson;

public class ContactPersonController extends AbstractGenericControllerImpl<ContactPerson> {
    private final ContactPersonDaoImpl contactPersonDao = new ContactPersonDaoImpl();

    @Override
    public AbstractGenericDaoImpl<ContactPerson> getDao(){
        return contactPersonDao;
    }
}
