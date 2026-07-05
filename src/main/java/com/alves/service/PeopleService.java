package com.alves.service;

import com.alves.entity.PeopleEntity;
import com.alves.repository.PeopleRepository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class PeopleService {

    private final PeopleRepository peopleRepository;

    public PeopleService(final PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Transactional
    public void insertPeople(List<PeopleEntity> people) {
        peopleRepository.insertPeople(people);
    }
}
