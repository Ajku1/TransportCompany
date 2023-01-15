package transportcompany.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import transportcompany.entity.Company;

import static org.junit.jupiter.api.Assertions.*;

class CompanyDAOTest extends UnitTest {

    @Test
    void saveCompany() {
        String companyName = "Company to save";
        Company company = new Company(companyName);

        CompanyDAO.saveCompany(company);

        assertTrue(CompanyDAO.doesCompanyExistByName(companyName));
    }

    @Test
    void updateCompany() {
        String companyName = "Company to update";
        Company company = new Company(companyName);
        CompanyDAO.saveCompany(company);
        String newCompanyName = "Updated Company";
        Company companyToUpdate = new Company(newCompanyName);

        CompanyDAO.updateCompany(companyToUpdate);

        assertTrue(CompanyDAO.doesCompanyExistByName(newCompanyName));
    }

    @Test
    void getCompanyById() {
        String companyName = "Company to get by id";
        Company company = new Company(companyName);
        CompanyDAO.saveCompany(company);
        Company savedCompany = CompanyDAO.getCompanyByName(companyName);

        assertNotNull(CompanyDAO.getCompanyById(savedCompany.getId()));
    }

    @Test
    void getCompanyByName() {
        String companyName = "Company To get by name";
        Company company = new Company(companyName);
        CompanyDAO.saveCompany(company);

        Company fetchedCompany = CompanyDAO.getCompanyByName(companyName);

        assertNotNull(fetchedCompany);
    }

    @Test
    void doesCompanyExistByName() {
        String companyName = "Company that is going to be checked if it exists by name";
        Company company = new Company(companyName);
        CompanyDAO.saveCompany(company);

        boolean doesCompanyExistByName = CompanyDAO.doesCompanyExistByName(companyName);

        assertTrue(doesCompanyExistByName);
    }

    @Test
    void getCompanies() {

        CompanyDAO.saveCompany(new Company("Company 1"));
        CompanyDAO.saveCompany(new Company("Company 2"));

        List<Company> companies = CompanyDAO.getCompanies();

        assertEquals(2, companies.size());
    }

    @Test
    void deleteCompany() {
        String companyName = "Company To Delete";
        Company company = new Company(companyName);
        CompanyDAO.saveCompany(company);

        CompanyDAO.deleteCompanyByName(company.getName());

        assertFalse(CompanyDAO.doesCompanyExistByName(companyName));
    }

}
