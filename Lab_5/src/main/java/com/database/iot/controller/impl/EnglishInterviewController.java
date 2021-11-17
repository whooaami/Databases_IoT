package com.database.iot.controller.impl;

import com.database.iot.model.dao.impl.AbstractGenericDaoImpl;
import com.database.iot.model.dao.impl.EnglishInterviewDaoImpl;
import com.database.iot.model.entities.EnglishInterview;

public class EnglishInterviewController extends AbstractGenericControllerImpl<EnglishInterview> {
    private final EnglishInterviewDaoImpl englishInterviewDao = new EnglishInterviewDaoImpl();

    @Override
    public AbstractGenericDaoImpl<EnglishInterview> getDao(){
        return englishInterviewDao;
    }
}
