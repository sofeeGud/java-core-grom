package lesson30.home;

import java.util.HashSet;

public class Controller {
    public HashSet<Employee> employeesByProject(String projectName) {
        return EmployeeDAO.employeesByProject(projectName);
    }

    public HashSet<Project> projectsByEmployee(Employee employee) {
        return ProjectDAO.projectsByEmployee(employee);
    }

    public HashSet<Employee> employeesByDepartmentWithoutProject(DepartmentType departmentType) {
        return EmployeeDAO.employeesByDepartmentWithoutProject(departmentType);
    }

    public HashSet<Employee> employeesWithoutProject() {
        return EmployeeDAO.employeesWithoutProject();
    }

    public HashSet<Employee> employeesByTeamLead(Employee lead) {
        return EmployeeDAO.employeesByTeamLead(lead);
    }

    public HashSet<Employee> teamLeadsByEmployee(Employee employee) {
        return EmployeeDAO.teamLeadsByEmployee(employee);
    }

    public HashSet<Employee> employeesByProjectEmployee(Employee employee) {
        return EmployeeDAO.employeesByProjectEmployee(employee);
    }

    public HashSet<Project> projectsByCustomer(Customer customer) {
        return ProjectDAO.projectsByCustomer(customer);
    }

    public HashSet<Employee> employeesByCustomerProjects(Customer customer) {
        return EmployeeDAO.employeesByCustomerProjects(customer);
    }
}
