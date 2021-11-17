package com.database.iot.controller.impl;

import com.database.iot.model.dao.impl.AbstractGenericDaoImpl;
import com.database.iot.model.dao.impl.MarkOfInterviewDaoImpl;
import com.database.iot.model.entities.MarkOfInterview;

public class MarkOfInterviewController extends AbstractGenericControllerImpl<MarkOfInterview> {
    private final MarkOfInterviewDaoImpl markOfInterviewDao = new MarkOfInterviewDaoImpl();

    @Override
    public AbstractGenericDaoImpl<MarkOfInterview> getDao(){
        return markOfInterviewDao;
    }
}
