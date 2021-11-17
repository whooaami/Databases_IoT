package com.database.iot.controller.impl;

import com.database.iot.model.dao.impl.AbstractGenericDaoImpl;
import com.database.iot.model.dao.impl.CandidateCvDaoImpl;
import com.database.iot.model.entities.CandidateCv;

public class CandidateCvController extends AbstractGenericControllerImpl<CandidateCv> {
    private final CandidateCvDaoImpl candidateCvDao = new CandidateCvDaoImpl();

    @Override
    public AbstractGenericDaoImpl<CandidateCv> getDao(){
        return candidateCvDao;
    }
}
