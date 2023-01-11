package transportcompany.entity.qualification;

import java.util.Set;
import javax.persistence.*;

import lombok.*;
import transportcompany.entity.EntityWithId;
import transportcompany.entity.person.Employee;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Qualification extends EntityWithId {

    @Column(name = "qualificationType", nullable = false)
    @Enumerated(EnumType.STRING)
    private QualificationType qualificationType;

    @ManyToMany
    private Set<Employee> employees;

}
