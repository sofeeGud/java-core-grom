package lesson35.repository;

import lesson35.model.User;
import lesson35.model.UserType;


public class UserRepository extends Repository<User> {
    private static final String path = "C:/Users/Lenovo T540p/Desktop/UserDb.txt";

    public UserRepository() throws Exception {
        super(path);
    }

    public User insertUser(User user) throws Exception {
        if (user.getUserType() == null)
            user.setUserType(UserType.USER);
        return writeToFile(user);
    }

    @Override
    public User parse(String line) {
        String[] userArr = line.split(",");
        return new User(Long.parseLong(userArr[0]), userArr[1], userArr[2], userArr[3], UserType.valueOf(userArr[4]));
    }

    public User findUserById(Long id) throws Exception {
        for (User user : getAll()) {
            if (user.getId() == id)
                return user;
        }
        return null;
    }


}

