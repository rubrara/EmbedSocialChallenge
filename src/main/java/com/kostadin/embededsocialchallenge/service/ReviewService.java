package com.kostadin.embededsocialchallenge.service;

import com.kostadin.embededsocialchallenge.model.Review;

import java.util.List;

public interface ReviewService {

    List<Review> listAll();

    List<Review> listFiltered(String rating, Integer minRating, String date, String text);
}
