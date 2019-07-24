package lesson13;

import java.util.Arrays;

public class Demo {

    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();

        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        User user1 = new User((long) 1, "user1", "aaa");
        userRepository.save(user1);
        User user2 = new User(0, null, "ddd");
        userRepository.save(user2);
        User user3 = null;
        userRepository.save(user3);
        userRepository.save(user1);
        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        User user4 = new User(0, "user4", null);
        userRepository.save(user4);
        User user5 = new User(55, "user5", "ccc");
        userRepository.save(user5);
        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        User user6 = new User((long) 4, "user6", null);
        userRepository.save(user6);
        User user7 = new User((long) 5, null, null);
        userRepository.save(user7);
        userRepository.save(null);
        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        userRepository.delete(1);
        System.out.println(Arrays.deepToString(userRepository.getUsers()));
        userRepository.delete(0);
        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        User user8 = new User(0, null, null);
        User user9 = new User((long) 4, "testName", "testId");
        userRepository.update(user8);
        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        userRepository.update(user9);
        System.out.println(Arrays.deepToString(userRepository.getUsers()));

    }
}

