package com.javi.moby.testUtils;

import com.google.gson.Gson;
import com.javi.moby.entity.model.Candidate;
import com.javi.moby.entity.model.CandidateXTechnology;
import com.javi.moby.entity.model.Technology;

import java.util.LinkedList;
import java.util.List;

public class TestEntityFactory {
    public static final Long ID_CANDIDATE = 1L;
    public static final Long ID_TECHNOLOGY = 1L;
    public static final Long ID_CANDIDATE_X_TEC = 1L;
    public static final String DNI_CANDIDATE = "38932329";
    public static final String TEC_NAME = "Java";

    public static Candidate getCandidateWithoutId(){
        return Candidate.builder()
                .firstName("Javier")
                .surname("Martinez")
                .identityType(null)
                .birthDate(null)
                .idNumber(DNI_CANDIDATE)
                .build();
    }

    public static Candidate getCandidateWithId(){
        return Candidate.builder()
                .idCandidate(ID_CANDIDATE)
                .firstName("Javier")
                .surname("Martinez")
                .identityType(null)
                .birthDate(null)
                .idNumber(DNI_CANDIDATE)
                .build();
    }

    public static Candidate getCandidateWithoutIdOrDni(){
        return Candidate.builder()
                .firstName("Javier")
                .surname("Martinez")
                .identityType(null)
                .birthDate(null)
                .idNumber(null)
                .build();
    }

    public static Candidate getCandidateWithModifiedId(){
        return Candidate.builder()
                .idCandidate(ID_CANDIDATE)
                .firstName("Javier")
                .surname("Martinez")
                .identityType(null)
                .birthDate(null)
                .idNumber(DNI_CANDIDATE)
                .build();
    }

    public static List<Candidate> getCandidateListWithId(){

        List<Candidate> candidatesList = new LinkedList<>();
        candidatesList.add(getCandidateWithId());

        return candidatesList;
    }

    public static Technology getTechnologyWithId(){
        return Technology.builder()
                .idTechnology(ID_TECHNOLOGY)
                .tecName(TEC_NAME)
                .version("20")
                .build();
    }

    public static Technology getTechnologyWithModifiedId(){
        return Technology.builder()
                .idTechnology(ID_TECHNOLOGY)
                .tecName("Java")
                .version("9")
                .build();
    }

    public static CandidateXTechnology getCandidateXTechnology(){
        return CandidateXTechnology.builder()
                .idCandidateXTechnology(ID_CANDIDATE_X_TEC)
                .candidate(getCandidateWithId())
                .technology(getTechnologyWithId())
                .build();
    }

    public static List<CandidateXTechnology> getCandidateXTechnologyList(){

        CandidateXTechnology candidateXTechnology = getCandidateXTechnology();

        List<CandidateXTechnology> listCandidateXTechnology = new LinkedList<>();

        listCandidateXTechnology.add(candidateXTechnology);

        return listCandidateXTechnology;
    }

    public static List<Technology> getTechnologyList(){
        List<Technology> technologyList = new LinkedList<>();

        technologyList.add(getTechnologyWithId());

        return technologyList;
    }

    public static String getCandidateWithIdJson(){return new Gson().toJson(getCandidateWithId());}

    public static String getCandidateWithModifiedIdJson(){return new Gson().toJson(getCandidateWithModifiedId());}

    public static Technology getTechnologyWithoutId(){
        return Technology.builder()
                .tecName("Java")
                .version("20")
                .build();
    }

    public static String getTechnologyWithIdJson(){return new Gson().toJson(getTechnologyWithId());}

    public static String getTechnologyWithoutIdJson(){return new Gson().toJson(getTechnologyWithoutId());}

    public static String getTechnologyWithModifiedIdJson(){return new Gson()
            .toJson(getTechnologyWithModifiedId());}

}
