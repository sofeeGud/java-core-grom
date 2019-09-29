package lesson27.hw;

import java.util.ArrayList;

public class UserRepository {

    private ArrayList<User> users = new ArrayList<>();

    public ArrayList<User> getUsers() {
        return users;
    }

    private User findById(long id) {
        int i = 0;
        for (User user : users) {
            if (user != null && id == user.getId()) {
                return users.get(i);
            }
            i++;
        }
        return null;
    }

    public User save(User user) {
        if (user == null)
            return null;

        if (findById(user.getId()) != null)
            return null;

        int i = 0;
        for (User us : users) {
            if (us == null) {
                users.add(user);
                break;
            }
            i++;
        }
        return user;
    }

    public User update(User user) {
        if (user == null)
            return null;

        int i = 0;
        for (User us : users) {
            if (us == findById(user.getId())) {
                users.add(user);
                break;
            }
            i++;
        }
        return user;
    }

    public void delete(long id) {
        int i = 0;
        for (User us : users) {
            if (us == findById(us.getId())) {
                users.remove(us);
                break;
            }
            i++;
        }
    }

}