package transportcompany.entity.vehicle;

import jakarta.persistence.*;
import lombok.*;

@Entity
@DiscriminatorValue("tankTruck")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class TankTruck extends Vehicle {
}
