package transportcompany.entity.person;

import jakarta.persistence.*;
import transportcompany.entity.EntityWithId;

import static jakarta.persistence.DiscriminatorType.STRING;

@Entity
@Inheritance
@DiscriminatorColumn(name="DISC", discriminatorType=STRING, length=20)
@Table(name = "people")
public abstract class Person extends EntityWithId {

}
