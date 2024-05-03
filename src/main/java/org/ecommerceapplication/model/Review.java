package org.ecommerceapplication.model;

public class Review {
    private String reviewId;
    private String userId;
    private String productId;
    private int rating;
    private String comment;

    public Review(String reviewId, String userId, String productId, int rating, String comment) {
        this.reviewId = reviewId;
        this.userId = userId;
        this.productId = productId;
        this.rating = rating;
        this.comment = comment;
    }
}