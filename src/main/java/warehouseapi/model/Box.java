package warehouseapi.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Box Entity
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Box {
    @Id
    @Column(name = "box_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(targetEntity = Product.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "box_id", referencedColumnName = "box_id")
    private Set<Product> products = new HashSet<>();
}
