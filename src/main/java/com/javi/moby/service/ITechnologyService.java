package com.javi.moby.service;

import com.javi.moby.entity.Candidate;
import com.javi.moby.entity.Technology;

import java.util.List;

public interface ITechnologyService {
    Technology fetchTechnologyById(Long id);

    Technology saveTechnology(Technology technology);

    List<Technology> listTechnologies();

    void deleteById(Long id);
}
