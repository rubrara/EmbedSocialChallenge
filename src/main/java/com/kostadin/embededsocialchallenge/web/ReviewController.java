package com.kostadin.embededsocialchallenge.web;

import com.kostadin.embededsocialchallenge.model.Review;
import com.kostadin.embededsocialchallenge.service.ReviewService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ReviewController {

    private final ReviewService service;

    public ReviewController(ReviewService service) {
        this.service = service;
    }

    @GetMapping({"/", "/show-reviews"})
    public List<Review> allReviews() {

        return service.listAll();
    }

    @PostMapping("/filter")
    public List<Review> filter(@RequestParam String rating, @RequestParam Integer minRating, @RequestParam String date, @RequestParam String text, Model model) {

        List<Review> filteredReviews = service.listFiltered(rating, minRating, date, text);

        return filteredReviews;
    }

}
