package transportcompany.entity.person;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Formula;
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
    private int age;

    @ManyToMany(mappedBy = "employees")
    private List<Qualification> qualifications;

}
