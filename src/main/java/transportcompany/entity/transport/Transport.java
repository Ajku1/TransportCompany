package transportcompany.entity.transport;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;
import transportcompany.entity.EntityWithId;

@Entity
@Table(name = "transports")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Transport extends EntityWithId {

    @Column(name = "startPoint", nullable = false)
    private String startPoint;

    @Column(name = "endPoint", nullable = false)
    private String endPoint;

    @Column(name = "departureDate", nullable = false)
    private LocalDate departureDate;

    @Column(name = "arrivalDate", nullable = false)
    private LocalDate arrivalDate;

    @Column(name = "transportType", nullable = false)
    private TransportType transportType;

    @Column(name = "cargoWeight")
    private double cargoWeight;

}
