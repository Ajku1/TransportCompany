package transportcompany.entity;

import java.util.*;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import transportcompany.entity.person.Employee;
import transportcompany.entity.transport.PricedTransport;
import transportcompany.entity.vehicle.Vehicle;

@Entity
@Table(name = "companies")
@Getter
@Setter
@ToString
public class Company extends EntityWithId {

    @NotBlank(message = "Company name cannot be blank!")
    @Size(max = 20, message = "Company name has to be with up to 20 characters!")
    @Pattern(regexp = "^([A-Z]).*", message = "Company name has to start with capital letter!")
    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "company")
    private List<Employee> employees = new ArrayList<>();

    @OneToMany(mappedBy = "company")
    private List<Vehicle> vehicles = new ArrayList<>();

    @OneToMany(mappedBy = "company")
    private List<PricedTransport> transports = new ArrayList<>();

    public Company() {
    }

    public Company(String name) {
        this.name = name;
    }

    public Company(String name, List<Employee> employees, List<Vehicle> vehicles, List<PricedTransport> transports) {
        this.name = name;
        this.employees = employees;
        this.vehicles = vehicles;
        this.transports = transports;
    }

}
