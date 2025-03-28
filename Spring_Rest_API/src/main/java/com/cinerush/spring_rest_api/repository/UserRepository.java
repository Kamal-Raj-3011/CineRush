package com.cinerush.spring_rest_api.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinerush.spring_rest_api.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

