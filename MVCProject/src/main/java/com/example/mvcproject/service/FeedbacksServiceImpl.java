package com.example.mvcproject.service;

import com.example.mvcproject.dao.FeedbacksRepository;
import com.example.mvcproject.entity.Feedbacks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FeedbacksServiceImpl implements FeedbacksService {
    private final FeedbacksRepository feedbacksRepository;

    @Autowired
    public FeedbacksServiceImpl(FeedbacksRepository theFeedbacksRepository) {
        feedbacksRepository = theFeedbacksRepository;
    }

    @Override
    public List<Feedbacks> findAll() {
        return feedbacksRepository.findAllByOrderByPhoneAsc();
    }

    @Override
    public Feedbacks findById(int theId) {
        Optional<Feedbacks> result = feedbacksRepository.findById(theId);

        Feedbacks theFeedbacks = null;

        if (result.isPresent()) {
            theFeedbacks = result.get();
        } else {
            throw new RuntimeException("Did not find feedback id - " + theId);
        }

        return theFeedbacks;
    }

    @Override
    public void save(Feedbacks theFeedbacks) {
        feedbacksRepository.save(theFeedbacks);
    }

    @Override
    public void deleteById(int theId) {
        feedbacksRepository.deleteById(theId);
    }
}
