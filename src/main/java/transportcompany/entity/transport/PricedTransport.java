package transportcompany.entity.transport;

import jakarta.persistence.*;
import lombok.*;
import transportcompany.entity.*;
import transportcompany.entity.person.Client;

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
    private Client client;

    @ManyToOne
    private Company company;

}
