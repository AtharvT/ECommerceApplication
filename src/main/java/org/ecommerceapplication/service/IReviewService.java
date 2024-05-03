package org.ecommerceapplication.service;

import org.ecommerceapplication.model.Review;

import java.util.List;

public interface IReviewService {
    void addReview(Review review);
    List<Review> getReviewsByProductId(String productId);
}