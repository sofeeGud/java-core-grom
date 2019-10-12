package lesson30.home;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class EmployeeDAO {
    public static ArrayList<Employee> employees = new ArrayList<>();

    public static HashSet<Employee> employeesByProject(String projectName) {
        HashSet<Employee> employeesSet = new HashSet<>();

        for (Employee emp : employees) {
            if (emp.getProjects() == null)
                continue;
            for (Project pr : emp.getProjects()) {
                if (pr.getName() != null || pr.equals(projectName))
                    employeesSet.add(emp);

            }
        }

        return employeesSet;

    }

    public static HashSet<Employee> employeesByDepartmentWithoutProject(DepartmentType departmentType) {
        HashSet<Employee> employeesSet = new HashSet<>();
        for (Employee emp : employees) {
            if (emp.getDepartment() != null && emp.getDepartment().getType().equals(departmentType)
                    && emp.getProjects().size() == 0)
                employeesSet.add(emp);
        }
        return employeesSet;
    }

    public static HashSet<Employee> employeesWithoutProject() {
        HashSet<Employee> employeesSet = new HashSet<>();
        for (Employee emp : employees) {
            if (emp != null && emp.getProjects().size() == 0)
                employeesSet.add(emp);
        }
        return employeesSet;

    }

    public static HashSet<Employee> employeesByTeamLead(Employee lead) {

        HashSet<Employee> employeesSet = new HashSet<>();
        for (Employee emp : employees) {
            if (emp.getProjects() != null && emp.getPosition() != null
                    && !emp.getPosition().equals(Position.TEAM_LEAD) && emp.getProjects().equals(lead.getProjects()))
                employeesSet.add(emp);
        }
        return employeesSet;

    }

    public static HashSet<Employee> teamLeadsByEmployee(Employee employee) {
        HashSet<Employee> employeesSet = new HashSet<>();
        for (Employee emp : employees) {
            if (emp.getPosition() != null && emp.getPosition().equals(Position.TEAM_LEAD)
                    && emp.getProjects().equals(employee.getProjects()))
                employeesSet.add(emp);
        }
        return employeesSet;

    }

    public static HashSet<Employee> employeesByProjectEmployee(Employee employee) {

        HashSet<Employee> employeesSet = new HashSet<>();
        for (Employee emp : employees) {
            if (emp.getProjects() != null && emp.getProjects().equals(employee.getProjects()))
                employeesSet.add(emp);
        }
        return employeesSet;
    }

    public static HashSet<Employee> employeesByCustomerProjects(Customer customer) {
        HashSet<Employee> employeesSet = new HashSet<>();
        for (Employee emp : employees) {
            for (Project pr : emp.getProjects()) {
                if (pr.getCustomer() != null && pr.getCustomer().equals(customer))
                    employeesSet.add(emp);
            }
        }
        return employeesSet;
    }

}
