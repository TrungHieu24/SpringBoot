package com.example.mvcproject.dao;

import com.example.mvcproject.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
    List<Feedback> findAllByOrderByLastNameAsc();
}




