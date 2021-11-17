package com.database.iot.controller.impl;

import com.database.iot.model.dao.impl.AbstractGenericDaoImpl;
import com.database.iot.model.dao.impl.TechnicalInterviewDaoImpl;
import com.database.iot.model.entities.TechnicalInterview;

public class TechnicalInterviewController extends AbstractGenericControllerImpl<TechnicalInterview>{
    private final TechnicalInterviewDaoImpl technicalInterviewDao = new TechnicalInterviewDaoImpl();

    @Override
    public AbstractGenericDaoImpl<TechnicalInterview> getDao(){
        return technicalInterviewDao;
    }
}
