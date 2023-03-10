package transportcompany.dao;

import java.util.List;

import jakarta.persistence.criteria.*;
import org.hibernate.*;
import transportcompany.configuration.SessionFactoryUtil;
import transportcompany.entity.person.Employee;

public class EmployeeDAO {

    public static void saveEmployee(Employee employee) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(employee);
            transaction.commit();
        }
    }

    public static void updateEmployee(Employee employee) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(employee);
            transaction.commit();
        }
    }

    public static void deleteEmployee(Employee employee) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(employee);
            transaction.commit();
        }
    }

    public static Employee getEmployeeByName(String name) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("select e from Employee e where e.name = :name", Employee.class)
                          .setParameter("name", name)
                          .getSingleResult();
        }
    }

    public static boolean doesEmployeeExistByName(String employeeName) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Employee employee = session.createQuery("select e from Employee e where e.name = :name", Employee.class)
                                       .setParameter("name", employeeName)
                                       .getSingleResultOrNull();
            return employee != null;
        }
    }

    public static List<Employee> sortEmployeesByQualificationThenSalary() {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
            Root<Employee> root = criteriaQuery.from(Employee.class);
            criteriaQuery
                .select(root)
                .orderBy(
                    criteriaBuilder.asc(root.get(Employee.Fields.qualifications)),
                    criteriaBuilder.asc(root.get(Employee.Fields.salary))
                        );
            return session.createQuery(criteriaQuery).getResultList();
        }
    }

}
