package com.penalty.catalog.services.penalty.entity;

import javax.persistence.*;

@Entity
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Weight getWeight() {
        return weight;
    }

    public void setWeight(Weight weight) {
        this.weight = weight;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public Category getPenaltyCategory() {
        return penaltyCategory;
    }

    public void setPenaltyCategory(Category category) {
        this.penaltyCategory = category;
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