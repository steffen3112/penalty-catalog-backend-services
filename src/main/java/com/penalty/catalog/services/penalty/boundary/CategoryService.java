package com.penalty.catalog.services.penalty.boundary;

import com.penalty.catalog.services.penalty.entity.Category;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class CategoryService {

    @PersistenceContext(unitName = "PenaltyDB")
    EntityManager em;

    // TODO: Adjust queries to filter the ones specifc for the team
    public Category getCategoryIfItExists(String categoryName) {

        TypedQuery<Category> query = em.createNamedQuery("findCategoryByName", Category.class);

        try {
            return query.setParameter("name", categoryName).getSingleResult();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }


}
