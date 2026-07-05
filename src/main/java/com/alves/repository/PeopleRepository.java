package com.alves.repository;

import com.alves.entity.PeopleEntity;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;

@ApplicationScoped
public class PeopleRepository implements PanacheRepository<PeopleEntity> {

    private final EntityManager entityManager;

    public PeopleRepository(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public void insertPeople(List<PeopleEntity> people) {

        for (PeopleEntity person : people) {
            entityManager.createQuery(
                """
                    INSERT INTO PeopleEntity(firstName, lastName, email, nickname, dateOfBirth, createdAt, updatedAt)
                    VALUES(:firstName, :lastName, :email, :nickname,  :dateOfBirth, :createdAt, :updatedAt)
                    ON CONFLICT(email)
                    DO NOTHING
                """
            )
                .setParameter("firstName", person.getFirstName())
                .setParameter("lastName", person.getLastName())
                .setParameter("email", person.getEmail())
                .setParameter("nickname", person.getNickname())
                .setParameter("dateOfBirth", person.getDateOfBirth())
                .setParameter("createdAt", person.getCreatedAt())
                .setParameter("updatedAt", person.getUpdatedAt())
                .executeUpdate();

        }
    }
}
