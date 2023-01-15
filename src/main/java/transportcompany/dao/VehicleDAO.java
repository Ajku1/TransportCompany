package transportcompany.dao;

import org.hibernate.*;
import transportcompany.configuration.SessionFactoryUtil;
import transportcompany.entity.vehicle.Vehicle;

public class VehicleDAO {

    public static void saveVehicle(Vehicle vehicle) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(vehicle);
            transaction.commit();
        }
    }

    public static void updateVehicle(Vehicle vehicle) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(vehicle);
            transaction.commit();
        }
    }

    public static Vehicle getVehicleById(long id) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("select c from Vehicle c where c.id = :id", Vehicle.class)
                          .setParameter("id", id)
                          .getSingleResult();
        }
    }

    public static Vehicle getVehicleByLicencePlate(String licencePlate) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("select c from Vehicle c where c.licencePlate = :licencePlate", Vehicle.class)
                          .setParameter("licencePlate", licencePlate)
                          .getSingleResult();
        }
    }

    public static boolean doesVehicleExistByLicencePlate(String licencePlate) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Vehicle vehicle = session.createQuery("select c from Vehicle c where c.licencePlate = :licencePlate", Vehicle.class)
                                     .setParameter("licencePlate", licencePlate)
                                     .getSingleResultOrNull();
            return vehicle != null;
        }
    }

    public static void deleteVehicleByLicencePlate(String licencePlate) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.createMutationQuery("delete from Vehicle where licencePlate = :licencePlate")
                   .setParameter("licencePlate", licencePlate).executeUpdate();
            session.getTransaction().commit();
        }
    }

}
