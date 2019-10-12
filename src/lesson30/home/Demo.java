package lesson30.home;


import java.util.Date;

public class Demo {
    public static void main(String[] args) {


        Customer customer1 = new Customer("Vasiliy", "Ukraine");
        Customer customer2 = new Customer("Natalya", "Ukraine");
        Customer customer3 = new Customer("Anna", "Ukraine");
        CustomerDAO.customers.add(customer1);
        CustomerDAO.customers.add(customer2);
        CustomerDAO.customers.add(customer3);

        Project project1 = new Project("Project1", customer1);
        Project project2 = new Project("Project2", customer1);
        Project project3 = new Project("Project3", customer2);
        ProjectDAO.projects.add(project1);
        ProjectDAO.projects.add(project2);
        ProjectDAO.projects1.add(project3);

        Department department = new Department(DepartmentType.DEVELOPERS, EmployeeDAO.employees);
        Department department1 = new Department(DepartmentType.SUPPORT, EmployeeDAO.employees);
        DepartmentDAO.departments.add(department);
        DepartmentDAO.departments.add(department1);


        Employee employee = new Employee("Oksana", "Oksi", new Date(), Position.ANALYST, department, ProjectDAO.projects);
        Employee employee1 = new Employee("Ivan", "Iv", new Date(), Position.DESIGNER, department, ProjectDAO.projects1);
        Employee employee2 = new Employee("Andrey", "Andy", new Date(), Position.TEAM_LEAD, department1, ProjectDAO.projects);
        Employee employee3 = new Employee("Sofia", "Sof", new Date(), Position.FINANCE, department, ProjectDAO.projects2);
        Employee employee4 = new Employee("Lida", "Lid", new Date(), Position.TEAM_LEAD, department, ProjectDAO.projects);
        Employee employee5 = new Employee("Maria", "Mary", new Date(), Position.ANALYST, department, ProjectDAO.projects);
        EmployeeDAO.employees.add(employee);
        EmployeeDAO.employees.add(employee1);
        EmployeeDAO.employees.add(employee2);
        EmployeeDAO.employees.add(employee3);
        EmployeeDAO.employees.add(employee4);


        Controller controller = new Controller();

        System.out.println(controller.employeesByProject("Project2"));

        System.out.println(controller.projectsByEmployee(employee2));

        System.out.println(controller.employeesByDepartmentWithoutProject(department.getType()));

        System.out.println((controller.employeesWithoutProject()));

        System.out.println(controller.employeesByTeamLead(employee4));

        System.out.println(controller.teamLeadsByEmployee(employee));

        System.out.println(controller.employeesByProjectEmployee(employee5));

        System.out.println(controller.projectsByCustomer(customer1));

        System.out.println(controller.employeesByCustomerProjects(customer1));
    }
}
