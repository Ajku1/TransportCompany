package transportcompany.entity.vehicle;

import jakarta.persistence.*;
import lombok.*;

@Entity
@DiscriminatorValue("lorry")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Lorry extends Vehicle {
}
