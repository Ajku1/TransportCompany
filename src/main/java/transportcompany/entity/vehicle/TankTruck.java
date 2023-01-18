package transportcompany.entity.vehicle;

import jakarta.persistence.*;
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
    private int maxLitersCapacity;

    public TankTruck(String licencePlate, Company company, int maxLitersCapacity) {
        super(licencePlate, company);
        this.maxLitersCapacity = maxLitersCapacity;
    }

}
