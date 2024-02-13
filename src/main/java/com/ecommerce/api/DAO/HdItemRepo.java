package com.ecommerce.api.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.api.Entities.HdItem;

public interface HdItemRepo extends JpaRepository<HdItem, Integer> {
    
}
