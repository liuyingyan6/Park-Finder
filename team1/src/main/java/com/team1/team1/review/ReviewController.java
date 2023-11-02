package com.team1.team1.review;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ReviewController {
    private List<Review> reviewList = List.of(
            new Review("aa", "HeathPark", 5, "Good place to walk my dogs! Love it!!", new Date()),
            new Review("kk", "ButePark", 4, "Beautiful", new Date()),
            new Review("abby", "ButePark", 1, "No lights in night.", new Date()),
            new Review("jessie", "ButePark", 5, "Love having a walk in Bute Park", new Date())
    );

    @GetMapping("/parkReviews")
    public ModelAndView parkReviews() {
        ModelAndView mav = new ModelAndView("ParkDetail");
        mav.addObject("reviews", reviewList);
        return mav;
    }

    @GetMapping("/reviewForm")
    public ModelAndView ReviewSubmit() {
        ModelAndView mav = new ModelAndView("ReviewForm");
        mav.addObject("review", new Review());
        return mav;
    }

    @PostMapping("/submitReviewForm")
    public ModelAndView submitReviewForm(@Valid @ModelAttribute("review") Review review,
                                         BindingResult bindingResult, Model model) {
        review.setCreateTime(new Date());
        if (bindingResult.hasErrors()) {
            ModelAndView mav = new ModelAndView("ReviewForm", model.asMap());
            System.out.println("Errors");
            return mav;
        }
        return new ModelAndView("redirect:/ParkDetail.html");
    }

    @GetMapping(value = "/parkReviews/{parkName}", produces = "application/json;charset=utf-8")
    public ModelAndView parkReviews(@PathVariable String parkName) {
        ModelAndView mav = new ModelAndView("ParkDetail");
        List<Review> accordingReviews = new ArrayList<>();
        for (Review review : reviewList) {
            if (review.getParkName().equals(parkName)){
                accordingReviews.add(review);
            }
        }
        mav.addObject("reviews", accordingReviews);
        return mav;
    }
}
