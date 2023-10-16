package com.realestate.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name="firstName")
    private String firstName;

     @Column(name="lastName")
    private String lastName;

     @Column(name="email", unique = true, nullable = false)
    private String email;

     @Column(name="password", nullable = false)
    private String password;

    @Column(name = "isAdmin", nullable = false)
    private Boolean isAdmin;

    @OneToOne
    @JoinColumn(name = "portfolio_id")
    private Portfolio portfolio;

    public User() {}

    // @ManyToMany
    // @JoinTable(
    //     name = "user_properties",
    //     joinColumns = @JoinColumn(name = "user_id"),
    //     inverseJoinColumns = @JoinColumn(name = "property_id"))
    // private List<Property> userProperties = new ArrayList<>();

    @OneToMany
    @JoinColumn(name="user_Id", referencedColumnName = "id")
    private List<Property> userProperties;

    public List<Property> getUserProperties() {
        return userProperties;
    }
    public void setUserProperties(List<Property> userProperties) {
        this.userProperties = userProperties;
    }
    public Long getId() {
        return id;
    }
    // public List<Property> getUserProperties() {
    //     return userProperties;
    // }
    // public void setUserProperties(List<Property> userProperties) {
    //     this.userProperties = userProperties;
    // }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Boolean getIsAdmin() {
        return isAdmin;
    }
    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

     @Override
    public String toString() {
        return "User [id=" + id + ", userName=" + email + ", password=" + password + "]";
    }

   
}

