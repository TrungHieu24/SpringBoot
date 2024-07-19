package com.example.mvcproject.service;

import com.example.mvcproject.entity.Feedbacks;

import java.util.List;

public interface FeedbacksService {
    public List<Feedbacks> findAll();

    public Feedbacks findById(int theId);

    public void save(Feedbacks theFeedback);

    public void deleteById(int theId);
}
