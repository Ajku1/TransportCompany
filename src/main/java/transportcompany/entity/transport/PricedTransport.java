package transportcompany.entity.transport;

import jakarta.persistence.*;
import lombok.*;
import transportcompany.entity.*;

@Entity
@Table(name = "pricedTransports")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class PricedTransport extends EntityWithId {

    @ManyToOne
    private Transport transport;

    @Column(name = "price", nullable = false)
    private double price;

    @ManyToOne
    private Company company;

}
