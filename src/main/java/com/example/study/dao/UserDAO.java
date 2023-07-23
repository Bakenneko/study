package com.example.study.dao;

import com.example.study.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository <User, Integer> {
    // всі CRUD операції
}
