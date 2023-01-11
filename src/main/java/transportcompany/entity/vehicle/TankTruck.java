package transportcompany.entity.vehicle;

import javax.persistence.*;

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
