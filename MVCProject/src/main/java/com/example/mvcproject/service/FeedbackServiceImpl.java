package com.example.mvcproject.service;

import com.example.mvcproject.dao.FeedbackRepository;
import com.example.mvcproject.entity.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    private final FeedbackRepository feedbackRepository;

    @Autowired
    public FeedbackServiceImpl(FeedbackRepository theFeedbackRepository) {
        feedbackRepository = theFeedbackRepository;
    }

    @Override
    public List<Feedback> findAll() {
        return feedbackRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public Feedback findById(int theId) {
        Optional<Feedback> result = feedbackRepository.findById(theId);

        Feedback theFeedback = null;

        if (result.isPresent()) {
            theFeedback = result.get();
        } else {
            throw new RuntimeException("Did not find feedback id - " + theId);
        }

        return theFeedback;
    }

    @Override
    public void save(Feedback theFeedback) {
        feedbackRepository.save(theFeedback);
    }

    @Override
    public void deleteById(int theId) {
        feedbackRepository.deleteById(theId);
    }
}
