package transportcompany.entity.vehicle;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.*;
import transportcompany.entity.Company;

@Entity
@DiscriminatorValue("bus")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Bus extends Vehicle {

    @Column(name = "people_capacity")
    @Positive
    private int peopleCapacity;

    public Bus(String licencePlate, Company company, int peopleCapacity) {
        super(licencePlate, company);
        this.peopleCapacity = peopleCapacity;
    }

    public void setPeopleCapacity(int peopleCapacity) {
        if(peopleCapacity <= 0) {
            throw new IllegalArgumentException("Bus cannot have a negative or zero capacity.");
        }
        this.peopleCapacity = peopleCapacity;
    }

}
