package transportcompany.entity.vehicle;

import jakarta.persistence.*;
import lombok.*;

@Entity
@DiscriminatorValue("tankTruck")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class TankTruck extends Vehicle {
}
