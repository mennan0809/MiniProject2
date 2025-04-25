package com.example.miniapp.services;

import com.example.miniapp.models.Rating;
import com.example.miniapp.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;

    @Autowired
    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public Rating addRating(Rating rating) {
        rating.setRatingDate(LocalDateTime.now());
        return ratingRepository.save(rating);
    }

    public Rating updateRating(String id, Rating updatedRating) {
        return ratingRepository.findById(id).map(existing -> {
            existing.setScore(updatedRating.getScore());
            existing.setComment(updatedRating.getComment());
            return ratingRepository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Rating not found with ID: " + id));
    }

    public void deleteRating(String id) {
        ratingRepository.deleteById(id);
    }

    public List<Rating> getRatingsByEntity(Long entityId, String entityType) {
        return ratingRepository.findByEntityIdAndEntityType(entityId, entityType);
    }

    public List<Rating> findRatingsAboveScore(int minScore) {
        return ratingRepository.findByScoreGreaterThan(minScore);
    }
}
