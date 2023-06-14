package com.realestate.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.realestate.model.Agent;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Integer>{
    
}
