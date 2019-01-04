package com.penalty.catalog.services.penalty.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedQuery(name = "findCategoryByName", query = "SELECT c FROM Category c WHERE c.name = :name")
public class Category {

    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private long id;
    private String name;

    @OneToMany(mappedBy = "penaltyCategory")
    private List<Penalty> penaltyList;

    public Category() {

    }

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}