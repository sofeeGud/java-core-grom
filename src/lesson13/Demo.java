package lesson13;

import java.util.Arrays;

public class Demo {

    public static void main(String[] args) {
        User[] users = {
                new User((long)1, "user1", "aaa"),
                new User((long)2, null, "bbb"),
                new User(0, "user3", "ccc"),
                new User((long)4, "user4", null),
                new User((long)5, null, null),
                new User(0, null, "ddd"),
                new User(0, "user5", null),
                new User(0, null, null),
                null
        };

        UserRepository userRep = new UserRepository(users);


        User result = userRep.save(new User((long)10, "new", "bbb"));

        userRep.save(result);
        System.out.println(result);

        System.out.println(userRep.findById(1));
        System.out.println(userRep.getUserByName("user5"));
        System.out.println(userRep.getUserNameById(4));

    }
}

