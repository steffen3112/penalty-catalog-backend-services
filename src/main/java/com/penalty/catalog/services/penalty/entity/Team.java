package com.penalty.catalog.services.penalty.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@NamedQuery(name = "findTeamById", query = "SELECT t FROM Team t WHERE t.id = :id")
public class Team {

    @Id
    @GeneratedValue
    @Column(name = "team_id")
    private String id;
    private String name;
    private String location;
    @OneToMany(mappedBy = "team")
    private Set<Penalty> penalty;

    public Team() {

    }

    public Team(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
