package com.example.user.Repository;

import com.example.user.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <User, Integer>{
    User findOneByEmailAndPassword(String email, String password);
    User findByEmail(String email);
}
