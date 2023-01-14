package org.example;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import transportcompany.configuration.SessionFactoryUtil;
import transportcompany.dao.CompanyDAO;
import transportcompany.entity.Company;
import transportcompany.entity.person.Employee;

public class Main {

    public static void main(String[] args) {

        // 1. Add transport company
        Company company = new Company("NBU");
        CompanyDAO.saveCompany(company);
        System.out.println(company);

        // 1. Edit transport company
        company.setName("Updated Company Name");
        CompanyDAO.updateCompany(company);
        System.out.println(company);

        // 1. Delete transport company
        CompanyDAO.deleteCompanyByName(company.getName());
        System.out.println(CompanyDAO.doesCompanyExistByName(company.getName()));
    }

}
