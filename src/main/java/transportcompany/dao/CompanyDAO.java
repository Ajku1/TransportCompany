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

    public static List<Company> getCompanies() {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("SELECT c FROM entities.entity.Company c", Company.class).getResultList();

        }
    }

}
