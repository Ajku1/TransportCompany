package transportcompany.entity.person;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.*;

import lombok.*;
import org.hibernate.annotations.Formula;
import transportcompany.entity.Company;
import transportcompany.entity.qualification.Qualification;

@Entity
@DiscriminatorValue("employee")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Employee extends Person {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Formula(value = "YEAR(NOW())-YEAR(birth_date)")
    private int age;

    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;

    @ManyToMany(mappedBy = "employees")
    @JoinTable(name = "employee_qualifications")
    private List<Qualification> qualifications;

}
