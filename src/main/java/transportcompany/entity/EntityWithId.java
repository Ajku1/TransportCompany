package transportcompany.entity;

import javax.persistence.*;

@MappedSuperclass
public abstract class EntityWithId {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

}
