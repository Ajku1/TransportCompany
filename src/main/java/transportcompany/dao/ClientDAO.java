package transportcompany.dao;

import org.hibernate.*;
import transportcompany.configuration.SessionFactoryUtil;
import transportcompany.entity.person.Client;

public class ClientDAO {

    public static void saveClient(Client client) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(client);
            transaction.commit();
        }
    }

    public static void updateClient(Client client) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(client);
            transaction.commit();
        }
    }

    public static Client getClientByName(String name) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("select c from Client c where c.name = :name", Client.class)
                          .setParameter("name", name)
                          .getSingleResult();
        }
    }

    public static boolean doesClientExistByName(String name) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Client client = session.createQuery("select c from Client c where c.name = :name", Client.class)
                                   .setParameter("name", name)
                                   .getSingleResultOrNull();
            return client != null;
        }
    }

    public static void deleteClientByName(String clientName) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.createMutationQuery("delete from Client where name = :name")
                   .setParameter("name", clientName)
                   .executeUpdate();
            session.getTransaction().commit();
        }
    }

}
