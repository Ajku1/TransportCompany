package transportcompany.entity.person;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import transportcompany.entity.*;

import static jakarta.persistence.DiscriminatorType.STRING;

@Entity
@Inheritance
@DiscriminatorColumn(name="DISC", discriminatorType=STRING, length=20)
@Table(name = "people")
public abstract class Person extends EntityWithId {

    @NotBlank(message = "Person name cannot be blank!")
    @Size(max = 20, message = "Person name has to be with up to 20 characters!")
    @Pattern(regexp = "^([A-Z]).*", message = "Person name has to start with capital letter!")
    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;

}
