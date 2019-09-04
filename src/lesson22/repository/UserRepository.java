package lesson22.repository;

public class UserRepository {

    private static User[] users = new User[10];

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

    public static long[] getUserIds() {
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

    public static String getUserNameById(long id) {
        for (User user : users) {
            if (user != null && id == user.getId()) {
                return user.getName();
            }
        }
        return null;
    }


    public static User getUserByName(String name) {
        for (User user : users) {
            if (user != null && user.getName() == name)
                return user;
        }
        return null;
    }

    public static User findById(long id) {
        for (User user : users) {
            if (user != null && id == user.getId())
                return user;
        }
        return null;

    }

    public static User getUserBySessionId(String sessionId) {
        for (User user : users) {
            if (user != null && sessionId == user.getSessionId())
                return user;
        }
        return null;
    }


    public static User save(User user) {
        if (user == null)
            return null;

        if (findById(user.getId()) != null)
            return null;

        int countPl = 0;
        for (User us : users) {
            if (us != null)
                countPl++;
        }

        if (countPl > 9)
            return null;

        int j = 0;
        for (User us : users) {
            if (us == null) {
                users[j] = user;
                break;
            }
            j++;
        }

        return user;
    }

    public static User update(User user) {
        if (user == null)
            return null;

        User curUser = findById(user.getId());
        if (curUser == null)
            return null;

        long curUserId = curUser.getId();


        int i = 0;
        for (User us : users) {
            if (us != null && us.getId() == curUserId) {
                users[i] = user;
                break;
            }
            i++;
        }
        return user;
    }

    public static void delete(long id) {
        User user = findById(id);
        if (user == null)
            return;

        int i = 0;
        for (User delUser : users) {
            if (delUser.getId() == user.getId()) {
                users[i] = null;
                break;
            }
            i++;
        }
    }

}