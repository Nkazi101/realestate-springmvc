package com.realestate.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name ="portfolio")
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany
    @JoinTable(
        name = "portfolio_properties",
        joinColumns = @JoinColumn(name = "portfolio_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "property_id", referencedColumnName = "id"))
    private List<Property> itemsInPortfolio;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Property> getItemsInPortfolio() {
        return itemsInPortfolio;
    }

    public void setItemsInPortfolio(List<Property> itemsInPortfolio) {
        this.itemsInPortfolio = itemsInPortfolio;
    }

    
    
}
