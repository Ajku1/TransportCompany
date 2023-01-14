package transportcompany.dao;

import org.hibernate.*;
import transportcompany.configuration.SessionFactoryUtil;
import transportcompany.entity.qualification.Qualification;

public class QualificationDAO {

    public static void saveQualification(Qualification qualification) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(qualification);
            transaction.commit();
        }
    }

}
