package transportcompany.dao;

import java.io.*;
import java.security.InvalidParameterException;
import java.util.List;

import jakarta.persistence.criteria.*;
import org.hibernate.*;
import transportcompany.configuration.SessionFactoryUtil;
import transportcompany.entity.Company;
import transportcompany.entity.transport.*;

public class TransportDAO {

    public static PricedTransport getPricedTransportById(long id) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("select pt from PricedTransport pt where pt.id = :id", PricedTransport.class)
                          .setParameter("id", id)
                          .getSingleResult();
        }
    }

    public static void savePricedTransport(PricedTransport pricedTransport) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(pricedTransport);
            transaction.commit();
        }
    }

    public static void updatePricedTransport(PricedTransport pricedTransport) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(pricedTransport);
            transaction.commit();
        }
    }

    public static List<PricedTransport> getPricedTransports() {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("select pt from PricedTransport pt", PricedTransport.class).getResultList();
        }
    }

    public static List<Transport> sortTransportsByDestination() {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Transport> criteriaQuery = criteriaBuilder.createQuery(Transport.class);
            Root<Transport> root = criteriaQuery.from(Transport.class);
            criteriaQuery.select(root).orderBy(criteriaBuilder.asc(root.get(Transport.Fields.endPoint)));
            return session.createQuery(criteriaQuery).getResultList();
        }
    }

    public static void payTransport(long clientId, long companyId, long pricedTransportId) {
        Company company = CompanyDAO.getCompanyById(companyId);
        PricedTransport pricedTransport = getPricedTransportById(pricedTransportId);
        if (clientId != pricedTransport.getClient().getId()) {
            throw new InvalidParameterException("The same client that booked this transport must pay.");
        }
        pricedTransport.setHasClientPaid(true);
        company.addIncome(pricedTransport.getPrice());
        CompanyDAO.updateCompany(company);
        updatePricedTransport(pricedTransport);
    }

    public void savePricedTransportsToFile() throws IOException {
        List<PricedTransport> pricedTransports = getPricedTransports();

        try (FileOutputStream fileOutputStream = new FileOutputStream("pricedTransports.tmp");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(pricedTransports);
        }
    }

    public List<PricedTransport> readPricedTransportsToFile() throws IOException, ClassNotFoundException {
        try (FileInputStream fileInputStream = new FileInputStream("pricedTransports.tmp");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            return (List<PricedTransport>) objectInputStream.readObject();
        }
    }

}
