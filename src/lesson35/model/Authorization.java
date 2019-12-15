package lesson35.model;

import lesson35.repository.UserRepository;

public class Authorization {
    private boolean isLogin = false;
    private User userNow;
    UserRepository userRepository = new UserRepository();

    public Authorization() {
    }

    public void login(String userName, String password) throws Exception {
        for (User us : userRepository.getAll()) {
            if (us.getUserName().equals(userName) || us.getPassword().equals(password)) {
                isLogin = true;
                userNow = us;
            }
        }
        if (!isLogin)
            System.err.println("Incorrect login " + userName + " or password " + password + " in method login");
    }

    public void logout() {
        isLogin = false;
    }

    public boolean checkIn() {
        return isLogin;
    }

    public boolean isAdmin() {
        return userNow.getUserType() == UserType.ADMIN;
    }
}
