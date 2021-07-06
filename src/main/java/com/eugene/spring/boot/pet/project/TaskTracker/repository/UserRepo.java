package com.eugene.spring.boot.pet.project.TaskTracker.repository;

import com.eugene.spring.boot.pet.project.TaskTracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.email = :username")
    User findByEmail(@Param("username") String username);

    @Query("SELECT u FROM User u WHERE u.verificationCode = :code")
     User findByVerificationCode(@Param("code") String code);
}
