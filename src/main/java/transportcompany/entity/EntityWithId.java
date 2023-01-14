package transportcompany.entity;

import jakarta.persistence.*;
import lombok.*;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public abstract class EntityWithId {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

}
