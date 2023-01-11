package transportcompany.entity.vehicle;

import javax.persistence.*;

import transportcompany.entity.*;

@MappedSuperclass
@Table(name = "vehicles")
public abstract class Vehicle extends EntityWithId {

    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;

}
