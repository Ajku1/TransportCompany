package transportcompany.entity.person;

import jakarta.persistence.*;
import lombok.*;
import transportcompany.entity.Company;

@Entity
@DiscriminatorValue("client")
@Getter
@Setter
@NoArgsConstructor
public class Client extends Person {

    @Column(name = "paid_obligations")
    private boolean paidObligations = Boolean.FALSE;


    public Client(String name, Company company) {
        super(name, company);
    }

}
