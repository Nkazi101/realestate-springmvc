package com.realestate.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.realestate.model.Property;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Integer> {

    List<Property> findBySize(Double size);

    List<Property> findBySold(boolean sold);

    @Query(value="select * from property where sold = false", nativeQuery = true)
    public List<Property> findPropertiesInInventory();
    
}
