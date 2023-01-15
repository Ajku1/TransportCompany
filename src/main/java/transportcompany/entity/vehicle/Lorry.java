package transportcompany.entity.vehicle;

import jakarta.persistence.*;
import lombok.*;
import transportcompany.entity.Company;

@Entity
@DiscriminatorValue("lorry")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Lorry extends Vehicle {

    @Column(name = "max_weight", nullable = false)
    private int maxWeight;

    public Lorry(String licencePlate, Company company, int maxWeight) {
        super(licencePlate, company);
        this.maxWeight = maxWeight;
    }

}
