package com.example.demo.Services;

import com.example.demo.Models.Rating;
import org.springframework.stereotype.Service;

@Service
public interface RatingService {

    Rating readRating(int id);
    Rating giveRating (Rating rating);
}
