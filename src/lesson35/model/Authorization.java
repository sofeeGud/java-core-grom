package lesson35.model;

import lesson35.repository.UserRepository;

public class Authorization {
    private boolean isLogin = false;
    private User user;
    UserRepository userRepository = new UserRepository();

    public Authorization() throws Exception {
    }

    public void login(String userName, String password) throws Exception {
        for (User us : userRepository.getAll()) {
            if ((userName == us.getUserName()) || (password == us.getPassword())) {
                us = user;
                isLogin = true;

            } else {
                System.err.println("Incorrect login or password");
                logout();
            }
        }
    }

    public void logout() {
        isLogin = false;
    }

    public boolean checkIn() throws Exception {
        return isLogin;
    }

    public boolean isAdmin() throws Exception {
        return user.getUserType()==UserType.ADMIN;
    }
}
