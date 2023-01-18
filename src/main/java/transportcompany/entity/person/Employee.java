package transportcompany.entity.person;

import java.time.LocalDate;
import java.util.*;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Formula;
import transportcompany.entity.Company;
import transportcompany.entity.qualification.Qualification;

@Entity
@DiscriminatorValue("employee")
@Getter
@Setter
@NoArgsConstructor
public class Employee extends Person {

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Formula(value = "YEAR(GETDATE())-YEAR(birth_date)")
    @Column(name = "age")
    private int age;

    @ManyToMany(mappedBy = "employees")
    private List<Qualification> qualifications = new ArrayList<>();

    public Employee(String name,
                    Company company,
                    LocalDate birthDate,
                    List<Qualification> qualifications) {
        super(name, company);
        this.birthDate = birthDate;
        this.qualifications = qualifications;
    }

    public Employee(String name,
                    Company company,
                    LocalDate birthDate) {
        super(name, company);
        this.birthDate = birthDate;
    }

}
