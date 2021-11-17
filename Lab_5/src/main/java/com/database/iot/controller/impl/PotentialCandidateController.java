package com.database.iot.controller.impl;

import com.database.iot.model.dao.impl.AbstractGenericDaoImpl;
import com.database.iot.model.dao.impl.PotentialCandidateDaoImpl;
import com.database.iot.model.entities.PotentialCandidate;

public class PotentialCandidateController extends AbstractGenericControllerImpl<PotentialCandidate> {
    private final PotentialCandidateDaoImpl potentialCandidateDao = new PotentialCandidateDaoImpl();

    @Override
    public AbstractGenericDaoImpl<PotentialCandidate> getDao(){
        return potentialCandidateDao;
    }
}
