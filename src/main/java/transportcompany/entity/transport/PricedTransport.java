package transportcompany.entity.transport;

import java.io.Serializable;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.*;
import transportcompany.entity.*;
import transportcompany.entity.person.*;

@Entity
@Table(name = "pricedTransports")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class PricedTransport extends EntityWithId implements Serializable {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "transport_id")
    private Transport transport;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "price", nullable = false)
    @Positive
    private double price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id")
    private Company company;

    @Column(name = "has_client_paid", nullable = false)
    private boolean hasClientPaid;

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be a positive number.");
        }
        this.price = price;
    }

}
