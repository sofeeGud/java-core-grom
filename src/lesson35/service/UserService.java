package lesson35.service;

import lesson35.repository.UserRepository;
import lesson35.model.User;

public class UserService {
    private UserRepository userRepository;

    public UserService() throws Exception {
        userRepository = new UserRepository();
    }

    public User registerUser(User user) throws NullPointerException {
        user.setId(userRepository.genId());
        try {
            if (!validateLog(user) || user.getPassword() == null || user.getCountry() == null) {
                System.err.println("User with id=" + user.getId() + " can not be registered");
            } else userRepository.insertUser(user);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return user;
    }

    private boolean validateLog(User user) throws Exception {

        //  проверить логин, в случае успеха вернуть true

        for (User user1 : userRepository.getAll()) {
            if (user.getUserName() != null && user1.getUserName().equals(user.getUserName())) {
                System.err.println("login already is using");
                return false;
            }
        }
        return true;
    }

}
