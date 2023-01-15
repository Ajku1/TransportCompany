package transportcompany.entity.vehicle;

import jakarta.persistence.*;
import lombok.*;
import transportcompany.entity.*;

import static jakarta.persistence.DiscriminatorType.STRING;

@Entity
@Inheritance
@DiscriminatorColumn(name="DISC", discriminatorType=STRING, length=20)
@Table(name = "vehicles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Vehicle extends EntityWithId {

    @Column(name = "licence_plate", nullable = false)
    private String licencePlate;

    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;

}
