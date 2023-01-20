package transportcompany.entity;

import java.util.*;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldNameConstants;
import transportcompany.entity.person.*;
import transportcompany.entity.transport.PricedTransport;
import transportcompany.entity.vehicle.Vehicle;

@Entity
@Table(name = "companies", uniqueConstraints = @UniqueConstraint(columnNames = { "name" }))
@Getter
@Setter
@NoArgsConstructor
@ToString
@FieldNameConstants
public class Company extends EntityWithId {

    @NotBlank(message = "Company name cannot be blank!")
    @Size(max = 20, message = "Company name has to be with up to 20 characters!")
    @Pattern(regexp = "^([A-Z]).*", message = "Company name has to start with capital letter!")
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "income")
    @PositiveOrZero
    private double income;

    @OneToMany(mappedBy = "company", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Employee> employees = new ArrayList<>();

    @OneToMany(mappedBy = "company", fetch = FetchType.EAGER)
    private List<Vehicle> vehicles = new ArrayList<>();

    @OneToMany(mappedBy = "company", fetch = FetchType.EAGER)
    private List<PricedTransport> transports = new ArrayList<>();

    @OneToMany(mappedBy = "company", fetch = FetchType.EAGER)
    private List<Client> clients = new ArrayList<>();

    public Company(String name) {
        this.name = name;
    }

    public Company(long id, String name) {
        super(id);
        this.name = name;
    }

    public Company(long id,
                   String name,
                   double income,
                   List<Employee> employees,
                   List<Vehicle> vehicles,
                   List<PricedTransport> transports) {
        super(id);
        this.name = name;
        this.income = income;
        this.employees = employees;
        this.vehicles = vehicles;
        this.transports = transports;
    }

    public Company(String name, double income, List<Employee> employees, List<Vehicle> vehicles, List<PricedTransport> transports) {
        this.name = name;
        this.income = income;
        this.employees = employees;
        this.vehicles = vehicles;
        this.transports = transports;
    }

    public void setName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Company name cannot be empty");
        }
        if (name.length() > 20) {
            throw new IllegalArgumentException("Name cannot be longer than 20 characters.");
        }
        if (!Character.isUpperCase(name.charAt(0))) {
            throw new IllegalArgumentException("Name must start with an uppercase character.");
        }
        this.name = name;
    }

    public void setIncome(double income) {
        if (income < 0) {
            throw new IllegalArgumentException("Income must be positive or zero.");
        }
        this.income = income;
    }

    public void addIncome(double income) {
        if (income < 0) {
            throw new IllegalArgumentException("Income must be positive or zero.");
        }
        this.income += income;
    }

}
