package com.realestate.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "property")
public class Property {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "description")
    private String description;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "size")
    private Double size;

    @Column(name = "price")
    private Double price;

    @Column(name = "contactInfo")
    private String contactInfo;

    @Column(name = "datePosted")
    private LocalDate datePosted;

    @Column(name = "sold", nullable = false )
    private boolean sold = false;

     @Column(name = "dateSold")
    private LocalDate dateSold;

    @OneToMany	    
	@JoinColumn(name="property_Id",referencedColumnName="id")
	private List<Photo> propertyPhotos;
	

    // @ManyToMany(mappedBy = "userProperties")
    // private List<User> users = new ArrayList<>();


   public List<Photo> getPropertyPhotos() {
        return propertyPhotos;
    }

    public void setPropertyPhotos(List<Photo> propertyPhotos) {
        this.propertyPhotos = propertyPhotos;
    }

    public void addPropertyPhoto(Photo photo) {
		this.propertyPhotos.add(photo);
	}
	public void deletePropertyPhoto(Photo photo) {
		this.propertyPhotos.remove(photo);
	}

@ManyToMany(mappedBy = "itemsInPortfolio") 
    private List<Portfolio> portfolios;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public LocalDate getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(LocalDate datePosted) {
        this.datePosted = datePosted;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

     @Override
    public String toString() {
        return "Property [id=" + id + ", datePosted="
                + datePosted + ", description=" + description + ", price=" + price + ", sold=" + sold
                + ", size=" + size + ", price=" + price + ", dateSold=" + dateSold + "]";
    }
   
}


