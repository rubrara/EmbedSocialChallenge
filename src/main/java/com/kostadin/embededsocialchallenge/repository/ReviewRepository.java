package com.kostadin.embededsocialchallenge.repository;

import com.kostadin.embededsocialchallenge.bootstrap.DataHolder;
import com.kostadin.embededsocialchallenge.model.Review;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReviewRepository {

    public List<Review> findAll() {
        return DataHolder.reviews;
    }

}
