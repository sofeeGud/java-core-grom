package lesson30.home;

import java.util.ArrayList;
import java.util.HashSet;

public class ProjectDAO {

    public static ArrayList<Project> projects = new ArrayList<>();
    public static ArrayList<Project> projects1 = new ArrayList<>();
    public static ArrayList<Project> projects2 = new ArrayList<>();

    public static HashSet<Project> projectsByEmployee(Employee employee) {
        HashSet<Project> projectsSet = new HashSet<>();

        for (Employee emp : EmployeeDAO.employees) {
            if (emp != null || emp.equals(employee)) {
                projectsSet.addAll(employee.getProjects());
            }

        }
        return projectsSet;
    }

    public static HashSet<Project> projectsByCustomer(Customer customer) {
        HashSet<Project> projectsSet = new HashSet<>();

        for (Project pr : projects) {
            if (pr.getCustomer() != null && pr.getCustomer().equals(customer)) {
                projectsSet.add(pr);
            }
        }
        return projectsSet;
    }
}
