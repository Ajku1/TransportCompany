package transportcompany.dao;

import java.time.LocalDate;
import java.util.*;

import transportcompany.entity.Company;
import transportcompany.entity.transport.PricedTransport;

public class InquiryDAO {

    public static double getShipmentsCount() {
        List<Company> companies = CompanyDAO.getCompanies();

        return companies
            .stream()
            .flatMap(company -> company.getTransports().stream())
            .count();
    }

    public static double getTotalShipmentsPrice() {
        List<Company> companies = CompanyDAO.getCompanies();

        return companies
            .stream()
            .flatMap(company -> company.getTransports().stream())
            .mapToDouble(PricedTransport::getPrice)
            .sum();
    }

    public static Map<String, Integer> getDriverTransportList() {
        List<Company> companies = CompanyDAO.getCompanies();

        Map<String, Integer> driverNameTransportCount = new HashMap<>();

        companies
            .stream()
            .flatMap(company -> company.getTransports().stream())
            .forEach(pricedTransport -> driverNameTransportCount.merge(pricedTransport.getEmployee().getName(), 1, Integer::sum));

        return driverNameTransportCount;
    }

    public static double getCompanyIncomeForPeriod(LocalDate startDate, LocalDate endDate) {
        List<Company> companies = CompanyDAO.getCompanies();

        return companies
            .stream()
            .flatMap(company -> company.getTransports().stream())
            .filter(pricedTransport -> pricedTransport.getTransport().getDepartureDate().isAfter(startDate)
                                       && pricedTransport.getTransport().getArrivalDate().isBefore(endDate)
                                       && pricedTransport.isHasClientPaid())
            .mapToDouble(PricedTransport::getPrice)
            .sum();
    }

    public static Map<String, Double> getDriverTotalTransportCompanyIncome() {
        List<Company> companies = CompanyDAO.getCompanies();

        Map<String, Double> driverNameTransportPrice = new HashMap<>();

        companies
            .stream()
            .flatMap(company -> company.getTransports().stream())
            .forEach(pricedTransport -> driverNameTransportPrice.merge(pricedTransport.getEmployee().getName(),
                                                                       pricedTransport.getPrice(),
                                                                       Double::sum));

        return driverNameTransportPrice;
    }

}
