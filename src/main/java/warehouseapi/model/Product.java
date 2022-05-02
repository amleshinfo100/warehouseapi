package warehouseapi.model;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;

/**
 * Product Entity
 */
@Getter
@Setter
@Entity
public class Product {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String code;
    private String name;
    private String details;
    @Column(name = "box_id")
    private Long boxId;
}
