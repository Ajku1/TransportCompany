package transportcompany.entity.vehicle;

import jakarta.persistence.*;
import lombok.*;
import transportcompany.entity.Company;

@Entity
@DiscriminatorValue("bus")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Bus extends Vehicle {

    @Column(name = "people_capacity", nullable = false)
    private int peopleCapacity;

    public Bus(String licencePlate, Company company, int peopleCapacity) {
        super(licencePlate, company);
        this.peopleCapacity = peopleCapacity;
    }

}
