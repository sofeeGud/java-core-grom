package lesson20.task1;

import lesson20.task1.exception.BadRequestException;
import lesson20.task1.exception.InternalServelException;
import lesson20.task1.exception.UserNotFoundException;

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

    public User findById(long id) throws UserNotFoundException {
        for (User user : users) {
            if (user != null && id == user.getId())
                return user;
        }
        throw new UserNotFoundException("User with id: " + id + " not found");

    }

    public User getUserBySessionId(String sessionId) {
        for (User user : users) {
            if (user != null && sessionId == user.getSessionId())
                return user;
        }
        return null;
    }


    public User save(User user) throws Exception {
        if (user == null)
            throw new BadRequestException("Can't save null user");

        try {
            findById(user.getId());
            throw new BadRequestException("user with id: " + user.getId() + " already exist");

        } catch (UserNotFoundException e) {
            System.err.println("User with id: " + user.getId() + " not found. Will be saved.");
        }

 /*       int i = 0;
        for (User us : users) {
            if (us != null)
                i++;
        }
        if (i > 9)
            return null;*/

        int j = 0;
        for (User us : users) {
            if (us == null) {
                users[j] = user;
                return users[j];
            }
            j++;
        }

        throw new InternalServelException("Not enough space to save user with id: " + user.getId());
    }

    public User update(User user) throws Exception {
        if (user == null)
            throw new BadRequestException("Can't update null user");

        findById(user.getId());


        int i = 0;
        for (User us : users) {
            if (us != null && us.getId() == user.getId()) {
                users[i] = user;
                return users[i];
            }
            i++;
        }
        throw new InternalServelException("Unexpected error");
    }

    public void delete(long id) throws Exception {
        User user = findById(id);

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