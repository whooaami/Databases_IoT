package com.database.iot.controller.impl;

import com.database.iot.model.dao.impl.AbstractGenericDaoImpl;
import com.database.iot.model.dao.impl.VacancyDaoImpl;
import com.database.iot.model.entities.Vacancy;

public class VacancyController extends AbstractGenericControllerImpl<Vacancy> {
    private final VacancyDaoImpl vacancyDao = new VacancyDaoImpl();

    @Override
    public AbstractGenericDaoImpl<Vacancy> getDao(){
        return vacancyDao;
    }

}
