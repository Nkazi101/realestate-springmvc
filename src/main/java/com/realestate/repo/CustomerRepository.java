package com.realestate.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.realestate.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    
}

//Inside the <Customer, Integer> carrot, This is the entity class that the repository is managing. The repository will provide operations to manage Customer instances, including saving, deleting, and finding them. The Customer class is expected to be a JPA entity class that maps to a database table.
//Integer: This is the type of the ID (primary key) of the entity class. In this case, it's an Integer, which means that the Customer entity class should have an ID field of type Integer
 