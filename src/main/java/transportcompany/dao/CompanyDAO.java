package transportcompany.dao;

import java.util.List;

import org.hibernate.*;
import transportcompany.configuration.SessionFactoryUtil;
import transportcompany.entity.Company;

public class CompanyDAO {

    public static void saveCompany(Company company) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(company);
            transaction.commit();
        }
    }

    public static void updateCompany(Company company) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(company);
            transaction.commit();
        }
    }

    public static Company getCompanyById(long id) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("select c from Company c where c.id = :id", Company.class)
                          .setParameter("id", id)
                          .getSingleResult();
        }
    }

    public static Company getCompanyByName(String name) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("select c from Company c where c.name = :name", Company.class)
                          .setParameter("name", name)
                          .getSingleResult();
        }
    }

    public static boolean doesCompanyExistByName(String name) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Company company = session.createQuery("select c from Company c where c.name = :name", Company.class)
                                     .setParameter("name", name)
                                     .getSingleResultOrNull();
            return company != null;
        }
    }

    public static List<Company> getCompanies() {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("select c from Company c", Company.class).getResultList();
        }
    }

    public static void deleteCompanyByName(String companyName) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.createMutationQuery("delete from Company where name = :name")
                   .setParameter("name", companyName)
                   .executeUpdate();
            session.getTransaction().commit();
        }
    }

}
