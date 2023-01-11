package transportcompany.entity.transport;

import javax.persistence.*;

import lombok.*;
import transportcompany.entity.EntityWithId;

@Entity
@Table(name = "pricedTransports")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class PricedTransport extends EntityWithId {

    @ManyToOne
    private Transport transport;

    @Column(name = "price", nullable = false)
    private double price;

}
