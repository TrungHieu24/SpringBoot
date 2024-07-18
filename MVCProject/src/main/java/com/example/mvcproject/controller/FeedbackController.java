package com.example.mvcproject.controller;

import java.util.List;


import com.example.mvcproject.entity.Feedback;
import com.example.mvcproject.service.FeedbackService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/feedbacks")
public class FeedbackController {

    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService theFeedbackService) {
        feedbackService = theFeedbackService;
    }

    @GetMapping("/list")
    public String listFeedbacks(Model theModel) {
        List<Feedback> theFeedbacks = feedbackService.findAll();
        theModel.addAttribute("feedbacks", theFeedbacks);
        return "feedbacks/list-feedbacks";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        Feedback theFeedback = new Feedback();
        theModel.addAttribute("feedback", theFeedback);
        return "feedbacks/feedback-form";
    }

    @PostMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("feedbackId") int theId, Model theModel) {
        Feedback theFeedback = feedbackService.findById(theId);
        theModel.addAttribute("feedback", theFeedback);
        return "feedbacks/feedback-form";
    }


    @PostMapping("/save")
    public String saveFeedback(@ModelAttribute("feedback") Feedback theFeedback) {
        feedbackService.save(theFeedback);
        return "redirect:/feedbacks/list";
    }


    @PostMapping("/delete")
    public String delete(@RequestParam("feedbackId") int theId) {
       feedbackService.deleteById(theId);
        return "redirect:/feedbacks/list";
    }
}

