package com.ecommerce.api.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.api.Entities.User;

public interface UserLoginRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}
