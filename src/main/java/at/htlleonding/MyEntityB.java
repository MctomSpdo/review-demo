package at.htlleonding;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "B")
public class MyEntityB extends PanacheEntity {
    public String field;
}
