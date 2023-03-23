package com.kostadin.embededsocialchallenge.service.impl;

import com.kostadin.embededsocialchallenge.model.Review;
import com.kostadin.embededsocialchallenge.repository.ReviewRepository;
import com.kostadin.embededsocialchallenge.service.ReviewService;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository repository;

    public ReviewServiceImpl(ReviewRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Review> listAll() {
        return repository.findAll();
    }

    @Override
    public List<Review> listFiltered(String rating, Integer minRating, String date, String text) {

        List<Review> result = repository.findAll();

        if (minRating > 1)
            result = result.stream()
                    .filter(r -> r.getRating() >= minRating)
                    .collect(Collectors.toList());

        return result.stream()
                .sorted(getComparator(date))
                .sorted(getComparator(rating))
                .sorted(getComparator(text))
                .collect(Collectors.toList());

    }

    private Comparator<Review> getComparator(String s) {

        if (s.startsWith("Highest"))
            return Comparator.comparing(Review::getRating).reversed();
        else if (s.startsWith("Lowest"))
            return Comparator.comparing(Review::getRating);
        else if (s.startsWith("Oldest"))
            return Comparator.comparing(Review::getReviewCreatedOnDate);
        else if (s.startsWith("Newest"))
            return Comparator.comparing(Review::getReviewCreatedOnDate).reversed();
        else if (s.equals("Yes"))
            return ((a, b) -> {
                if (a.getReviewText().isBlank()) return 1;
                if (b.getReviewText().isBlank()) return -1;
                return 0;
            });
        else return (a, b) -> 0;
    }


}
