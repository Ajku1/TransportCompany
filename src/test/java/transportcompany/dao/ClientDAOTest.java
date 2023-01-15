package transportcompany.dao;

import org.junit.jupiter.api.*;
import transportcompany.entity.Company;
import transportcompany.entity.person.Client;

import static org.junit.jupiter.api.Assertions.*;

class ClientDAOTest extends UnitTest {

    private Company company;

    @BeforeEach
    void beforeEach() {
        String companyName ="Employee Company";
        CompanyDAO.saveCompany(new Company(companyName));
        company = CompanyDAO.getCompanyByName(companyName);
    }

    @Test
    void saveClient() {
        String clientName = "Client to save";
        Client client = new Client(clientName, company);

        ClientDAO.saveClient(client);

        assertTrue(ClientDAO.doesClientExistByName(clientName));
    }

    @Test
    void updateClient() {
        String clientName = "Client to update";
        Client client = new Client(clientName, company);
        ClientDAO.saveClient(client);
        String newClientName = "Updated Client";
        Client clientToUpdate = new Client(newClientName, company);

        ClientDAO.updateClient(clientToUpdate);

        assertTrue(ClientDAO.doesClientExistByName(newClientName));
    }

    @Test
    void deleteClient() {
        String clientName = "Client To Delete";
        Client client = new Client(clientName, company);
        ClientDAO.saveClient(client);

        ClientDAO.deleteClientByName(client.getName());

        assertFalse(ClientDAO.doesClientExistByName(clientName));
    }

}
