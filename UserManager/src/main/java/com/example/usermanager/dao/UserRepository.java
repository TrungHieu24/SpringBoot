package com.example.usermanager.dao;

import com.example.usermanager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findAllByOrderByNameAsc();
    @Query("SELECT u FROM User u WHERE u.name LIKE %:keyword%")
    List<User> findByName(@Param("keyword") String keyword);
}
