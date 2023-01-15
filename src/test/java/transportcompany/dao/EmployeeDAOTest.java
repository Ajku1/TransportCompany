package transportcompany.dao;

import java.time.LocalDate;

import org.junit.jupiter.api.*;
import transportcompany.entity.Company;
import transportcompany.entity.person.Employee;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeDAOTest extends UnitTest {

    private Company company;

    @BeforeEach
    void beforeEach() {
        String companyName ="Employee Company";
        CompanyDAO.saveCompany(new Company(companyName));
        company = CompanyDAO.getCompanyByName(companyName);
    }

    @Test
    void saveEmployee() {
        String employeeName = "Employee to save";
        Employee employee = new Employee(employeeName, company, LocalDate.of(1990, 1, 12));

        EmployeeDAO.saveEmployee(employee);

        assertTrue(EmployeeDAO.doesEmployeeExistByName(employeeName));
    }

    @Test
    void updateEmployee() {
        String employeeName = "Employee to update";
        Employee employee = new Employee(employeeName, company, LocalDate.of(1990, 1, 12));
        EmployeeDAO.saveEmployee(employee);
        Employee employeeToUpdate = EmployeeDAO.getEmployeeByName(employeeName);
        String newEmployeeName = "Updated Employee";
        employeeToUpdate.setName(newEmployeeName);

        EmployeeDAO.updateEmployee(employeeToUpdate);

        assertTrue(EmployeeDAO.doesEmployeeExistByName(newEmployeeName));
    }

    @Test
    void deleteEmployee() {
        Employee employee = new Employee("Name", company, LocalDate.of(1990, 1, 12));
        EmployeeDAO.saveEmployee(employee);
        Employee employeeToDelete = EmployeeDAO.getEmployeeByName(employee.getName());

        EmployeeDAO.deleteEmployee(employeeToDelete);

        assertFalse(EmployeeDAO.doesEmployeeExistByName(employee.getName()));
    }

}
