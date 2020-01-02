package lesson35.service;

import lesson35.repository.UserRepository;
import lesson35.model.User;

public class UserService {
    private UserRepository userRepository;

    public UserService() {
        userRepository = new UserRepository();
    }

    public User registerUser(User user) throws Exception {
        user.setId(userRepository.genId());
        try {
            if (!validateLog(user) || user.getPassword() == null || user.getCountry() == null) {
                throw new Exception("User with id=" + user.getId() + " can not be registered in method registerUser");
            } else userRepository.insertUser(user);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return user;
    }

    private boolean validateLog(User user) throws Exception {

        //  проверить логин, в случае успеха вернуть true

        for (User user1 : userRepository.getAll()) {
            if (user.getUserName() != null && user1.getUserName().equals(user.getUserName())) {
                System.err.println("login " + user.getUserName() + " already is using in method validateLog");
                return false;
            }
        }
        return true;
    }

}
