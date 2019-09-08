package lesson25.homework;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        GeneralDAO<Solution> generaSolutionlDAO = new GeneralDAO<>();
        Solution solution1 = new Solution("aaa");
        Solution solution2 = new Solution("bbb");
        Solution solution3 = new Solution("ccc");
        Solution solution5 = new Solution("ddd");
        Solution solution6 = new Solution("ddd");
        Solution solution4 = null;

        Solution[] solutions = {solution1, solution2, solution3, solution4};
        for (Solution sl : solutions) {
            try {
                generaSolutionlDAO.save(sl);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

        }

        //System.out.println(Arrays.deepToString(solutions));
        System.out.println(Arrays.deepToString(generaSolutionlDAO.getAll()));

        System.out.println("--------------------------------------------------------------------------------------------");

        GeneralDAO<User> userGeneralDAO = new GeneralDAO<>();

        User user1 = new User(11);
        User user2 = new User(12);
        User user3 = new User(13);
        User user4 = new User(15);
        User user5 = new User(11);
        //User user6 = null;

        User[] users = {user1, user2, user3, user5};
        for (User us : users) {
            try {
                userGeneralDAO.save(us);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

        }

        //System.out.println(Arrays.deepToString(solutions));
        System.out.println(Arrays.deepToString(userGeneralDAO.getAll()));

    }
}

