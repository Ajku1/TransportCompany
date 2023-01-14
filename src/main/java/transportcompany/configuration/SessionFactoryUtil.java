package transportcompany.configuration;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import transportcompany.entity.Company;
import transportcompany.entity.person.Employee;
import transportcompany.entity.qualification.Qualification;
import transportcompany.entity.transport.*;
import transportcompany.entity.vehicle.*;

public class SessionFactoryUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(Company.class);
            configuration.addAnnotatedClass(Qualification.class);
            configuration.addAnnotatedClass(Employee.class);
            configuration.addAnnotatedClass(Transport.class);
            configuration.addAnnotatedClass(PricedTransport.class);
            configuration.addAnnotatedClass(Vehicle.class);
            configuration.addAnnotatedClass(Bus.class);
            configuration.addAnnotatedClass(Lorry.class);
            configuration.addAnnotatedClass(TankTruck.class);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }

        return sessionFactory;
    }

}
