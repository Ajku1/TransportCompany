package transportcompany.entity.vehicle;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.*;
import transportcompany.entity.Company;

@Entity
@DiscriminatorValue("tankTruck")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class TankTruck extends Vehicle {

    @Column(name = "max_liters_capacity")
    @Positive
    private int maxLitersCapacity;

    public TankTruck(String licencePlate, Company company, int maxLitersCapacity) {
        super(licencePlate, company);
        this.maxLitersCapacity = maxLitersCapacity;
    }

    public void setMaxLitersCapacity(int maxLitersCapacity) {
        if (maxLitersCapacity <= 0) {
            throw new IllegalArgumentException("Max liters capacity cannot be less or equal to zero.");
        }
        this.maxLitersCapacity = maxLitersCapacity;
    }

}
