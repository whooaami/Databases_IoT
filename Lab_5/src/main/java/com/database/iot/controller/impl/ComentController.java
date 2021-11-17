package com.database.iot.controller.impl;

import com.database.iot.model.dao.impl.AbstractGenericDaoImpl;
import com.database.iot.model.dao.impl.ComentDaoImpl;
import com.database.iot.model.entities.Coment;

public class ComentController extends AbstractGenericControllerImpl<Coment>{
    private final ComentDaoImpl comentDao = new ComentDaoImpl();

    @Override
    public AbstractGenericDaoImpl<Coment> getDao(){
        return comentDao;
    }
}
