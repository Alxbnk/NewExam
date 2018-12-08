package com.example.demo.Repositories;

import com.example.demo.Models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class RatingRepoImpl implements RatingRepo{

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public Rating readRating(int id) {
        String sql = "SELECT idrating, evaluation, ascore, tscore, idkitchen, judge.idjudge, judge.firstname, judge.lastname FROM rating " +
                "INNER JOIN judge ON judge.idjudge = rating.idjudge " +
                "WHERE idkitchen = ?";

        RowMapper<Rating> rowMapper = new BeanPropertyRowMapper<>(Rating.class);
        Rating rating = jdbc.queryForObject(sql, rowMapper, id);

        return rating;
    }

    @Override
    public Rating giveRating(Rating rating) {
        return null;
    }
}
