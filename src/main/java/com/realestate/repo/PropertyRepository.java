package com.realestate.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.realestate.model.Property;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Integer> {
    
}
