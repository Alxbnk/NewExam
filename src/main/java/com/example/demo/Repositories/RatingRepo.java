package com.example.demo.Repositories;

import com.example.demo.Models.Rating;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepo {

    Rating readRating(int id);
    Rating giveRating (Rating rating);
}
