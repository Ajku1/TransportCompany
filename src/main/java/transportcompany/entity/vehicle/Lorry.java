package transportcompany.entity.vehicle;

import javax.persistence.*;

import lombok.*;

@Entity
@DiscriminatorValue("lorry")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Lorry extends Vehicle {
}
