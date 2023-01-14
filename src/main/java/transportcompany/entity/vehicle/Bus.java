package transportcompany.entity.vehicle;

import jakarta.persistence.*;
import lombok.*;

@Entity
@DiscriminatorValue("bus")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Bus extends Vehicle {
}
