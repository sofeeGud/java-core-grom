package lesson35.demo;

import lesson35.controller.UserController;
import lesson35.model.User;
import lesson35.model.UserType;

public class DemoUser {
    public static void main(String[] args) throws Exception {

        UserController userController = new UserController();
        User user1 = new User(0, "login11", "password1", "country1", UserType.ADMIN);
        User user2 = new User(0, "login22", "password2", "country2", UserType.USER);
        User user3 = new User(0, "login33", "password3", "country3", null);
        User[] users = {user1, user2, user3};

        try {
            for (User us : users) {
                userController.registerUser(us);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());

            for (StackTraceElement stackTrace : e.getStackTrace()) {
                System.err.println(stackTrace);
            }
        }
    }
}
