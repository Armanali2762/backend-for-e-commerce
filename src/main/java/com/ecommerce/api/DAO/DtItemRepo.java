package com.ecommerce.api.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.api.Entities.DtItem;

public interface DtItemRepo extends JpaRepository <DtItem,Integer> {
    
}
