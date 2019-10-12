package lesson30.home;

import java.util.ArrayList;

public class Department {

    private DepartmentType type;
    private ArrayList<Employee> employees;

    public Department(DepartmentType type, ArrayList<Employee> employees) {
        this.type = type;
        this.employees = employees;
    }

    public DepartmentType getType() {
        return type;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }



    @Override
    public String toString() {
        return "Department{" +
                "type=" + type +
                ", employees=" + employees +
                '}';
    }
}
