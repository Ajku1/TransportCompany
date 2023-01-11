package transportcompany.entity.vehicle;

import javax.persistence.*;

import lombok.*;

@Entity
@DiscriminatorValue("bus")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Bus extends Vehicle {
}
