package com.penalty.catalog.services.penalty.entity;

import javax.persistence.*;
import java.util.List;

@Entity
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Penalty> getPenaltyList() {
        return penaltyList;
    }

    public void setPenaltyList(List<Penalty> penaltyList) {
        this.penaltyList = penaltyList;
    }
}