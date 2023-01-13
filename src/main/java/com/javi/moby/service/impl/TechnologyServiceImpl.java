package com.javi.moby.service.impl;

import com.javi.moby.entity.model.Technology;
import com.javi.moby.exception.TechnologyAlreadyExistsException;
import com.javi.moby.repository.ITechnologyRepository;
import com.javi.moby.service.ITechnologyService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log
@Service
public class TechnologyServiceImpl implements ITechnologyService {

    @Autowired
    private ITechnologyRepository repository;

    @Override
    public Technology fetchTechnologyById(Long id) {
        if(repository.findById(id).isEmpty())
            throw new TechnologyAlreadyExistsException();
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
