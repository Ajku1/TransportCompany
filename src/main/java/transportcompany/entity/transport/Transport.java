package transportcompany.entity.transport;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldNameConstants;
import transportcompany.entity.EntityWithId;

@Entity
@Table(name = "transports")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldNameConstants
public class Transport extends EntityWithId {

    @Column(name = "startPoint", nullable = false)
    private String startPoint;

    @Column(name = "endPoint", nullable = false)
    private String endPoint;

    @Column(name = "departureDate", nullable = false)
    private LocalDate departureDate;

    @Column(name = "arrivalDate", nullable = false)
    private LocalDate arrivalDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "transportType", nullable = false)
    private TransportType transportType;

    @Column(name = "cargoWeight")
    private double cargoWeight;

    public void setDepartureDate(LocalDate departureDate) {
        if (departureDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Date of departure must be in the future.");
        }
        this.departureDate = departureDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        if (arrivalDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Date of arrival must be in the future.");
        }
        if (arrivalDate.isBefore(departureDate)) {
            throw new IllegalArgumentException("Date of arrival must be after date of departure.");
        }
        this.arrivalDate = arrivalDate;
    }

}
