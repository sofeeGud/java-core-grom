package lesson15.hw5;

public class UserRepository {


    private User[] users = new User[7];

    //public UserRepository(User[] users) {
    //    this.users = users;
    //}


    public User[] getUsers() {
        return users;
    }


    public User save(User user) {
        for (User newUser : users) {
            if (user != null && newUser != null && newUser.getId() == user.getId()) {
                return null;
            }
            for (int i = 0; i < users.length; i++) {

                if (users[i] == null) {
                    users[i] = user;
                    return user;
                }
            }
        }
        return null;
    }


    public User update(User user) {
        for (User newUser : users) {
            if (user != null && newUser != null && newUser.getId() == user.getId()) {
                for (int i = 0; i < users.length; i++) {
                    if (users[i].getId() == user.getId()) {
                        users[i] = user;
                        return user;
                    }
                }
            }
        }
        return null;
    }

    public void delete(long id) {
        for (User newUser : users) {
            for (int i = 0; i < users.length; i++) {
                if (users[i] != null && users[i].getId() == id) {
                    users[i] = null;
                }
            }
        }

    }

    public User findUser(User user) {
        if (user != null) {
            for (User newUser : users) {
                if (newUser != null && newUser.equals(user)) {
                    return newUser;
                }
            }
        }

        return null;
    }

}
