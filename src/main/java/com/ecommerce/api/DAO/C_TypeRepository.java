package com.ecommerce.api.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import com.ecommerce.api.Entities.Cloth_Type;

public interface C_TypeRepository extends JpaRepository<Cloth_Type, Integer> {

    @Query("SELECT c FROM Cloth_Type c WHERE c.Nu_category_id IN :ids")
    List<Cloth_Type> getAllClothByIds(@Param("ids") List<Integer> ids);

    
    
}
