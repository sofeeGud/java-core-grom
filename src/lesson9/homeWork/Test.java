package lesson9.homeWork;

public class Test {

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

        System.out.println(result);

    }
}
