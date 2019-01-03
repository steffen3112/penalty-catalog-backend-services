package com.penalty.catalog.services.penalty.boundary;

import com.penalty.catalog.services.penalty.entity.Penalty;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
//@DeclareRoles(value = { "admin" })
public class PenaltyService {

    @PersistenceContext(unitName = "PenaltyDB")
    EntityManager em;

    @RolesAllowed(value = { "admin" })
    public List<Penalty> getPenalties() {

        Query query = em.createQuery("SELECT p FROM Penalty p");

        return (List<Penalty>) query.getResultList();

    }

    @RolesAllowed(value = { "admin" })
    public void savePenalty(Penalty penalty) {

        em.persist(penalty);

    }

}
