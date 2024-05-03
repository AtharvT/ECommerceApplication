package org.ecommerceapplication.service;

import org.ecommerceapplication.model.User;

public interface IUserService {
    void registerUser(User user);
    void removeUser(String userId);
}
