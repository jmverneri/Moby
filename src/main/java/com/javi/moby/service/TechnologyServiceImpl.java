package com.javi.moby.service;

import com.javi.moby.entity.Candidate;
import com.javi.moby.entity.Technology;
import com.javi.moby.exception.ResourceNotFoundEx;
import com.javi.moby.repository.ITechnologyRepository;

import java.util.List;

public class TechnologyServiceImpl implements ITechnologyService{

    private ITechnologyRepository repository;

    public TechnologyServiceImpl(ITechnologyRepository repository) {
        this.repository = repository;
    }

    @Override
    public Technology fetchTechnologyById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundEx("Technology", "Id", id));
    }

    @Override
    public Technology saveTechnology(Technology technology) {
        return repository.save(technology);
    }

    @Override
    public List<Technology> listTechnologies() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
