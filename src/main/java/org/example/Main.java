package org.example;

import transportcompany.dao.CompanyDAO;
import transportcompany.entity.Company;

public class Main {
    public static void main(String[] args) {

        Company company = new Company();
        CompanyDAO.saveCompany(company);
        System.out.println(company);
    }
}
