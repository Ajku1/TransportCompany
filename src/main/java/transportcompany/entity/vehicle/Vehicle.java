package transportcompany.entity.vehicle;

import jakarta.persistence.*;
import transportcompany.entity.*;

import static jakarta.persistence.DiscriminatorType.STRING;

@Entity
@Inheritance
@DiscriminatorColumn(name="DISC", discriminatorType=STRING, length=20)
@Table(name = "vehicles")
public abstract class Vehicle extends EntityWithId {

    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;

}
