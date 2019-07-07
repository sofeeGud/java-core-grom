package lesson9.homeWork;

public class UserRepository {

    private User[] users;

    public UserRepository(User[] users) {
        this.users = users;
    }

    public User[] getUsers() {
        return users;
    }


    public String[] getUserNames() {

        String[] newName = new String[users.length];
        int i = 0;

        for (User user : users) {
            if (user != null)
                newName[i++] = user.getName();
        }
        return newName;
    }

    public long[] getUserIds() {
        int len = 0;
        for (User user : users) {
            if (user != null && user.getId() != 0)
                len++;
        }

        long[] newId = new long[len];
        int i = 0;
        for (User user : users) {
            if (user != null && user.getId() != 0) {
                newId[i++] = user.getId();
            }
        }
        return newId;
    }

    public String getUserNameById(long id) {
        for (User user : users) {
            if (user != null && id == user.getId()) {
                return user.getName();
            }
        }
        return null;
    }


    public User getUserByName(String name) {
        for (User user : users) {
            if (user != null && user.getName() == name)
                return user;
        }
        return null;
    }

    public User findById(long id) {
        for (User user : users) {
            if (user != null && id == user.getId())
                return user;
        }
        return null;
    }

    public User getUserBySessionId(String sessionId) {
        for (User user : users) {
            if (user != null && sessionId == user.getSessionId())
                return user;
        }
        return null;
    }


    public User save(User user) {
        if (user != null && findById(user.getId()) != null && findById(user.getId()).getId() == user.getId()) {
            return null;
        }
        for (int i = 0; i < users.length; i++) {

            if (users[i] == null) {
                users[i] = user;
                return user;
            }
        }
        return null;

    }

    public User update(User user) {
        if (user != null && findById(user.getId()) != null && findById(user.getId()).getId() == user.getId()) {
            for (int i = 0; i < users.length; i++) {

                if (users[i].getId() == user.getId()) {
                    users[i] = user;
                    return user;
                }
            }
        }
        return null;
    }

    public void delete(long id) {
        for (User newUser : users) {
            if (newUser != null && id == newUser.getId()) {
                for (int i = 0; i < users.length; i++) {

                    if (users[i] == newUser) {
                        users[i] = null;
                    }
                }
            }
        }
    }
}