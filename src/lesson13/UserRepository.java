package lesson13;

public class UserRepository {

    private User[] users = new User[4];


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

        if (user != null && findById(user.getId()) == null) {
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
        if (findById(user.getId()) != null) {

            User findedUser = findById(user.getId());

            findedUser.setName(user.getName());
            findedUser.setSessionId(user.getSessionId());

            return findedUser;
        }
        return null;
    }

    public void delete(long id) {


        if (findById(id) != null) {
            for (int i = 0; i < users.length; i++) {

                if (users[i] != null && users[i].getId() == id) {
                    users[i] = null;
                }
            }
        }


    }


}