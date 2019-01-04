package com.penalty.catalog.services.penalty.entity;

import javax.persistence.*;

@Entity
@NamedQuery(name = "allPenalties", query = "SELECT p FROM Penalty p")
public class Penalty {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String description;
    private Weight weight;
    private double amount;
    private int unit;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", foreignKey = @ForeignKey(name = "FK_CATEGORY"))
    private Category penaltyCategory;

    public Penalty() {

    }

    public Penalty(String name, String description, Weight weight, double amount, int unit, Category penaltyCategory) {
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.amount = amount;
        this.unit = unit;
        this.penaltyCategory = penaltyCategory;
    }
    
    @Override
    public String toString() {
        return "Penalty{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", weight=" + weight +
                ", amount=" + amount +
                ", unit=" + unit +
                ", category=" + penaltyCategory.getName() +
                '}';
    }

    public enum Weight {
        LOW, MEDIUM, HIGH;
    }

}