package com.javi.moby.service;

import com.javi.moby.entity.Technology;
import com.javi.moby.exception.ResourceNotFoundException;
import com.javi.moby.repository.ITechnologyRepository;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.List;

@Log
@Service
public class TechnologyServiceImpl implements ITechnologyService{

    private ITechnologyRepository repository;

    public TechnologyServiceImpl(ITechnologyRepository repository) {
        this.repository = repository;
    }

    @Override
    public Technology fetchTechnologyById(Long id) {
        if(repository.findById(id).isEmpty())
            throw new ResourceNotFoundException("The technology can not be found by the Id provided");
        return repository.findById(id).get();
    }

    @Override
    public Technology saveTechnology(Technology technology) {
        Technology toSave = repository.save(technology);
        log.info("The technology has been successfully saved");
        return toSave;
    }

    @Override
    public List<Technology> listTechnologies() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
        log.info("The technology has been successfully deleted");
    }
}
