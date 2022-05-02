package warehouseapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import warehouseapi.model.Box;


/**
 * Repository class for Warehouse Box
 */
@Repository
public interface BoxRepo extends JpaRepository<Box, Long> {
}
