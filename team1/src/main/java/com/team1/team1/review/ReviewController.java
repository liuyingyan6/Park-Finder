package com.team1.team1.review;

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
        ModelAndView mav = new ModelAndView("ParkReview");
        List<Review> accordingReviews = new ArrayList<>();
        for (Review review : reviewList) {
            if (parkName.equalsIgnoreCase(review.getParkName())) {
                accordingReviews.add(review);
            }
        }
        mav.addObject("reviews", accordingReviews);
        mav.addObject("review", new Review("", parkName, 0, "", null));
        
        // calculate rating average
        double averageRating = calculateAverageRating(accordingReviews);
        mav.addObject("averageRating", averageRating);
        return mav;
    }

    private double calculateAverageRating(List<Review> reviews) {
        if (reviews.isEmpty()) {
            return 0.0;
        }
        double totalRating = 0.0;
        for (Review review : reviews) {
            totalRating += review.getRating();
        }
        return totalRating / reviews.size();
    }

    @PostMapping("/submitReviewForm")
    public ModelAndView submitReviewForm(@ModelAttribute("review") Review review,
                                         BindingResult bindingResult, Model model) {
        review.setCreateTime(new Date());
        System.out.println(review);
        reviewList.add(review);

        String redirectUrl = "redirect:/parkReviews/" + review.getParkName();
        ModelAndView modelAndView = new ModelAndView(redirectUrl);
        return modelAndView;
    }


}
