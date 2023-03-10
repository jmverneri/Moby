package com.javi.moby.service;

import com.javi.moby.entity.model.CandidateXTechnology;
import java.util.List;

public interface ICandidateXTecService {

    CandidateXTechnology saveCandidateXTec(CandidateXTechnology candidateXTechnology);

    CandidateXTechnology updateCandidateXTec(CandidateXTechnology candidateXTechnology);

    List<CandidateXTechnology> listCandidatesXTec();
}
