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

    @Column(name = "qualificationType", nullable = false)
    @Enumerated(EnumType.STRING)
    private QualificationType qualificationType;

    @ManyToMany
    private Set<Employee> employees;

}
