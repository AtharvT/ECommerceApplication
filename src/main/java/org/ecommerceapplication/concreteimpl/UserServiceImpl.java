package org.ecommerceapplication.concreteimpl;

import org.ecommerceapplication.service.IUserService;
import org.ecommerceapplication.model.User;

import java.util.Map;

public class UserServiceImpl implements IUserService {

    private final Map<String, User> userIdMap;

    public UserServiceImpl(Map<String, User> userIdMap) {
        this.userIdMap = userIdMap;
    }

    @Override
    public void registerUser(User user) {
        if (userIdMap.containsKey(user.getUserId())) {
            System.out.println("User already registered in system");
            return;
        }

        userIdMap.put(user.getUserId(), user);
    }

    @Override
    public void removeUser(String userId) {
        if (!userIdMap.containsKey(userId)) {
            System.out.println("User not present in system");
            return;
        }

        userIdMap.remove(userId);
    }

    public boolean isUserRegistered(String userId) {
        return userIdMap.containsKey(userId);
    }
}
