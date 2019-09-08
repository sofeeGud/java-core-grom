package lesson25.homework;

public class Solution {
    private String name;

    public Solution(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Solution solution = (Solution) o;

        return name.equals(solution.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Solution{" +
                "name='" + name + '\'' +
                '}';
    }
}
