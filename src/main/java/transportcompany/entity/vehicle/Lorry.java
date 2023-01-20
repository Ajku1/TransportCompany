package transportcompany.entity.vehicle;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.*;
import transportcompany.entity.Company;

@Entity
@DiscriminatorValue("lorry")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Lorry extends Vehicle {

    @Column(name = "max_weight")
    @Positive
    private int maxWeight;

    public Lorry(String licencePlate, Company company, int maxWeight) {
        super(licencePlate, company);
        this.maxWeight = maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        if (maxWeight <= 0) {
            throw new IllegalArgumentException("Max weight cannot be less or equal to zero.");
        }
        this.maxWeight = maxWeight;
    }

}
