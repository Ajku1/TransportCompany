package transportcompany.entity.qualification;

import java.util.Set;

import jakarta.persistence.*;
import lombok.*;
import transportcompany.entity.EntityWithId;
import transportcompany.entity.person.Employee;

@Entity
@Table(name = "qualifications")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Qualification extends EntityWithId {

    @Enumerated(EnumType.STRING)
    @Column(name = "qualificationType", nullable = false)
    private QualificationType qualificationType;

    @ManyToMany
    @JoinTable(name = "qualifications_people",
            joinColumns = @JoinColumn(name = "qualifications_id"),
            inverseJoinColumns = @JoinColumn(name = "employees_id"))
    private Set<Employee> employees;

}
