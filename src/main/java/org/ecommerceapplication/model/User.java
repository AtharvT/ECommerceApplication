package org.ecommerceapplication.model;

public class User {

    private final String userId;
    private final String userName;
    private UserRole userRole;

    private Cart cart;

    public User(String userId, String userName, UserRole userRole) {
        this.userId = userId;
        this.userName = userName;
        this.userRole = userRole;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }


    public boolean isRegistered() {
        return userRole == UserRole.REGISTERED;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
