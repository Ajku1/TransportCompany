package transportcompany.entity.person;

import jakarta.persistence.*;
import lombok.*;

@Entity
@DiscriminatorValue("client")
@Getter
@Setter
@NoArgsConstructor
public class Client extends Person {

}
