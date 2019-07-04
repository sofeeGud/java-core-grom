package lesson8.homework2;


public class Demo {
    public static void main(String[] args) {

    }

    public static Student createHighestParent() {

        Student student = new Student("Valia", "Fedorkina", 56, new Course[]{});

        return student;
    }

    SpecialStudent createLowestChild() {
        SpecialStudent specialStudent = new SpecialStudent("Oksana", "Petrova", 2, new Course[]{}, 12, "gmail");
        return specialStudent;
    }
}
