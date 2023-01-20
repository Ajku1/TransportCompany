package transportcompany.entity.person;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import transportcompany.entity.*;

import static jakarta.persistence.DiscriminatorType.STRING;

@Entity
@Inheritance
@DiscriminatorColumn(name = "DISC", discriminatorType = STRING, length = 20)
@Table(name = "people")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Person extends EntityWithId {

    @NotBlank(message = "Person name cannot be blank!")
    @Size(max = 20, message = "Person name has to be with up to 20 characters!")
    @Pattern(regexp = "^([A-Z]).*", message = "Person name has to start with capital letter!")
    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;

    public void setName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Person name cannot be empty");
        }
        if (name.length() > 20) {
            throw new IllegalArgumentException("Name cannot be longer than 20 characters.");
        }
        if (!Character.isUpperCase(name.charAt(0))) {
            throw new IllegalArgumentException("Name must start with an uppercase character.");
        }
        this.name = name;
    }

}
