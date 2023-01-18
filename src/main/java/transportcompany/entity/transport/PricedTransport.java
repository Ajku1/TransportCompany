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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "transport_id")
    private Transport transport;

    @Column(name = "price", nullable = false)
    private double price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id")
    private Company company;

}
