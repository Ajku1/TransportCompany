package transportcompany.entity.person;

import java.time.LocalDate;
import java.util.*;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldNameConstants;
import org.hibernate.annotations.Formula;
import transportcompany.entity.Company;
import transportcompany.entity.qualification.Qualification;

@Entity
@DiscriminatorValue("employee")
@Getter
@Setter
@NoArgsConstructor
@FieldNameConstants
public class Employee extends Person {

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Formula(value = "YEAR(GETDATE())-YEAR(birth_date)")
    @Column(name = "age")
    @Min(18)
    private int age;

    @Column(name = "salary")
    @Positive
    private double salary;

    @ManyToMany(mappedBy = "employees")
    private List<Qualification> qualifications = new ArrayList<>();

    public Employee(String name,
                    Company company,
                    LocalDate birthDate,
                    double salary,
                    List<Qualification> qualifications) {
        super(name, company);
        this.birthDate = birthDate;
        this.salary = salary;
        this.qualifications = qualifications;
    }

    public Employee(String name,
                    Company company,
                    LocalDate birthDate,
                    double salary) {
        super(name, company);
        this.birthDate = birthDate;
        this.salary = salary;
    }

    public void setAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Drivers cannot be less than 18 years of age.");
        }
        this.age = age;
    }

    public void setSalary(double salary) {
        if (salary <= 0) {
            throw new IllegalArgumentException("Salary must be a positive number");
        }
        this.salary = salary;
    }

}
