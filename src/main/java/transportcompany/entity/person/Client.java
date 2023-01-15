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

    public Client(String name, Company company) {
        super(name, company);
    }

}
