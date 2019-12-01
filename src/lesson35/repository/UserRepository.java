package lesson35.repository;

import lesson35.model.User;
import lesson35.model.UserType;

import java.io.*;
import java.util.*;

public class UserRepository extends Repository<User> {
    private static final String path = "C:/Users/Lenovo T540p/Desktop/UserDb.txt";

    public UserRepository() throws Exception {
        super(path);
    }

    public User insertUser(User user) throws Exception {
        mapping();
        if (user.getUserType() == null)
            user.setUserType(UserType.USER);
        return writeToFile(user);
    }


    public Set<User> mapping() throws Exception {

        Set<User> users = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                users.add(parseUser(line));
            }
        } catch (IOException e) {
            throw new Exception("Reading from file " + path + " failed");
        }
        return users;
    }

    private User parseUser(String line) {
        String[] userArr = line.split(",");
        return new User(Long.parseLong(userArr[0]), userArr[1], userArr[2], userArr[3], UserType.valueOf(userArr[4]));
    }
}

