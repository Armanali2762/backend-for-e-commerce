package com.ecommerce.api.DAO;

import org.springframework.data.repository.CrudRepository;
import com.ecommerce.api.Entities.All_Categories;

public interface AllcatRepository extends CrudRepository<All_Categories, Integer> {

    
}