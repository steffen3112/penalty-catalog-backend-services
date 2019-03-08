package com.penalty.catalog.services.penalty.boundary;

import com.penalty.catalog.services.penalty.entity.Penalty;

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

        Query query = em.createNamedQuery("allPenalties", Penalty.class);

        return (List<Penalty>) query.getResultList();

    }

    // TODO: Handle duplicate Insertions, the penalties have to be unique in the table
    @RolesAllowed(value = { "admin" })
    public void savePenalty(Penalty penalty) {

        em.persist(penalty);

    }

}
