package com.realestate.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.realestate.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value="select * from user where email = ?1 and password = ?2", nativeQuery = true)
    public User signIn(String email, String password);

    @Query(value="select * from user where email = ?1", nativeQuery = true) //make sure field matches database exactly
    public User findByEmail(String email);


}

//Inside the <Customer, Integer> carrot, This is the entity class that the repository is managing. The repository will provide operations to manage Customer instances, including saving, deleting, and finding them. The Customer class is expected to be a JPA entity class that maps to a database table.
//Integer: This is the type of the ID (primary key) of the entity class. In this case, it's an Integer, which means that the Customer entity class should have an ID field of type Integer
 