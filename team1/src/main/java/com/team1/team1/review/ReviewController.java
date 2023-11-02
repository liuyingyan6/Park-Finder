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
    private List<Review> reviewList = new ArrayList<>();


    //        <a th:href="@{/parkReviews/ButePark}">修改</a>
    @GetMapping(value = "/parkReviews/{parkName}", produces = "application/json;charset=utf-8")
    public ModelAndView parkReviews(@PathVariable String parkName) {
        ModelAndView mav = new ModelAndView("ParkDetail");
        List<Review> accordingReviews = new ArrayList<>();
        for (Review review : reviewList) {
            if (parkName.equalsIgnoreCase(review.getParkName())) {
                accordingReviews.add(review);
            }
        }
        mav.addObject("reviews", accordingReviews);
        return mav;
    }

    @GetMapping("/reviewForm/{parkName}")
    public ModelAndView ReviewSubmit(@PathVariable String parkName) {
        ModelAndView mav = new ModelAndView("ReviewForm");
        mav.addObject("review", new Review("", parkName, 0, "", null));
        return mav;
    }

    @PostMapping("/submitReviewForm")
    public ModelAndView submitReviewForm(@Valid @ModelAttribute("review") Review review,
                                         BindingResult bindingResult, Model model) {
        review.setCreateTime(new Date());
        System.out.println(review);
        reviewList.add(review);
//        if (bindingResult.hasErrors()) {
//            ModelAndView mav = new ModelAndView("ReviewForm", model.asMap());
//            return mav;
//        }
        ModelAndView modelAndView = new ModelAndView("redirect:/parkList.html");
        return modelAndView;
    }

}
