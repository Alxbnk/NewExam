package com.example.demo.Services;

import com.example.demo.Models.Rating;
import com.example.demo.Repositories.RatingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceImpl implements RatingService{

    @Autowired
    RatingRepo ratingRepo;

    @Override
    public Rating readRating(int id) {

        return ratingRepo.readRating(id);
    }

    @Override
    public Rating giveRating(Rating rating) {

        return ratingRepo.giveRating(rating);
    }
}
