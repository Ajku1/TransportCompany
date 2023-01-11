package transportcompany.entity;

import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.*;
import transportcompany.entity.person.Employee;
import transportcompany.entity.transport.PricedTransport;
import transportcompany.entity.vehicle.Vehicle;

@Entity
@Table(name = "companies")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Company {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Company name cannot be blank!")
    @Size(max = 20, message = "Company name has to be with up to 20 characters!")
    @Pattern(regexp = "^([A-Z]).*", message = "Company name has to start with capital letter!")
    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "company")
    private List<Employee> employees;

    @OneToMany(mappedBy = "company")
    private List<Vehicle> vehicles;

    @OneToMany(mappedBy = "company")
    private List<PricedTransport> transports;

}
