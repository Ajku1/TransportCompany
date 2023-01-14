package org.example;

import java.util.*;

import transportcompany.dao.*;
import transportcompany.entity.Company;
import transportcompany.entity.qualification.*;

public class Main {
    public static void main(String[] args) {

        // Company company = new Company("NBU");
        // CompanyDAO.saveCompany(company);
        // System.out.println(company);

        Qualification qualification = new Qualification(QualificationType.SPECIAL_CARGO, Set.of());
        QualificationDAO.saveQualification(qualification);
        System.out.println(qualification);
    }
}
