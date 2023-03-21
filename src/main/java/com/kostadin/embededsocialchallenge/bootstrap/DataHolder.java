package com.kostadin.embededsocialchallenge.bootstrap;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kostadin.embededsocialchallenge.model.Review;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

    public static List<Review> reviews = new ArrayList<>();

    @PostConstruct
    public void init() throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        File file = new File("src/main/resources/json/reviews.json");

        reviews.addAll(mapper.readValue(file, new TypeReference<List<Review>>() {}));
    }

}
