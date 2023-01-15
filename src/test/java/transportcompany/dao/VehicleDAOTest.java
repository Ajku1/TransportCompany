package transportcompany.dao;

import org.junit.jupiter.api.*;
import transportcompany.entity.Company;
import transportcompany.entity.vehicle.*;

import static org.junit.jupiter.api.Assertions.*;

class VehicleDAOTest extends UnitTest {

    private Company company;

    @BeforeEach
    void beforeEach() {
        String companyName ="Employee Company";
        CompanyDAO.saveCompany(new Company(companyName));
        company = CompanyDAO.getCompanyByName(companyName);
    }

    @Test
    void saveVehicle() {
        String vehicleLicencePlate = "A9999CC";
        Vehicle vehicle = new Bus(vehicleLicencePlate, company, 15);

        VehicleDAO.saveVehicle(vehicle);

        assertTrue(VehicleDAO.doesVehicleExistByLicencePlate(vehicleLicencePlate));
    }

    @Test
    void updateVehicle() {
        String vehicleLicencePlate = "A9999CC";
        Vehicle vehicle = new Bus(vehicleLicencePlate, company, 15);
        VehicleDAO.saveVehicle(vehicle);
        String newVehicleLicencePlate = "A0000CC";
        Vehicle vehicleToUpdate = VehicleDAO.getVehicleByLicencePlate(vehicleLicencePlate);

        VehicleDAO.updateVehicle(vehicleToUpdate);

        assertTrue(VehicleDAO.doesVehicleExistByLicencePlate(newVehicleLicencePlate));
    }

    @Test
    void getVehicleById() {
        String vehicleLicencePlate = "A9999CC";
        Vehicle vehicle = new Bus(vehicleLicencePlate, company, 15);

        VehicleDAO.saveVehicle(vehicle);
        Vehicle savedVehicle = VehicleDAO.getVehicleByLicencePlate(vehicleLicencePlate);

        assertNotNull(VehicleDAO.getVehicleById(savedVehicle.getId()));
    }

    @Test
    void getVehicleByName() {
        String vehicleLicencePlate = "A9999CC";
        Vehicle vehicle = new Bus(vehicleLicencePlate, company, 15);

        VehicleDAO.saveVehicle(vehicle);

        Vehicle fetchedVehicle = VehicleDAO.getVehicleByLicencePlate(vehicleLicencePlate);

        assertNotNull(fetchedVehicle);
    }

    @Test
    void doesVehicleExistByName() {
        String vehicleLicencePlate = "A9999CC";
        Vehicle vehicle = new Bus(vehicleLicencePlate, company, 15);

        VehicleDAO.saveVehicle(vehicle);

        boolean doesVehicleExistByName = VehicleDAO.doesVehicleExistByLicencePlate(vehicleLicencePlate);

        assertTrue(doesVehicleExistByName);
    }

    @Test
    void deleteVehicle() {
        String vehicleLicencePlate = "A9999CC";
        Vehicle vehicle = new Bus(vehicleLicencePlate, company, 15);

        VehicleDAO.saveVehicle(vehicle);

        VehicleDAO.deleteVehicleByLicencePlate(vehicle.getLicencePlate());

        assertFalse(VehicleDAO.doesVehicleExistByLicencePlate(vehicleLicencePlate));
    }

}
