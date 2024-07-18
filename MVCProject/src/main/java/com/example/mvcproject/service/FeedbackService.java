package com.example.mvcproject.service;

import com.example.mvcproject.entity.Feedback;

import java.util.List;

public interface FeedbackService {
    public List<Feedback> findAll();

    public Feedback findById(int theId);

    public void save(Feedback theFeedback);

    public void deleteById(int theId);
}
