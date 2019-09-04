package lesson22.repository;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {

        UserRepository userRepository = new UserRepository();

        User user1 = new User(1001, "daniil", "32434234sdsfuuuuo");

        UserRepository.save(user1);
        System.out.println(Arrays.deepToString(userRepository.getUsers()));


        User user2 = new User(1002, "Andrey", "645ljiju");

        UserRepository.save(user2);
        System.out.println(Arrays.deepToString(userRepository.getUsers()));


        User user3 = new User(1001, "Test", "32434234sdsfuuuuo");

        UserRepository.update(user3);

        System.out.println(Arrays.deepToString(userRepository.getUsers()));
        System.out.println(Arrays.deepToString(userRepository.getUsers()));
    }
}
