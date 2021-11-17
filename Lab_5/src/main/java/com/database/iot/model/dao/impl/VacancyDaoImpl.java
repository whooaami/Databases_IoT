package com.database.iot.model.dao.impl;

import com.database.iot.model.entities.ContactPerson;
import com.database.iot.model.entities.Vacancy;

public class VacancyDaoImpl extends AbstractGenericDaoImpl<Vacancy> {
    public VacancyDaoImpl(){
        super(Vacancy.class);
    }
}
