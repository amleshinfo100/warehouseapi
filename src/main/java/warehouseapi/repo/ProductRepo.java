package warehouseapi.repo;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import warehouseapi.model.Product;

import java.util.List;
import java.util.Optional;

/**
 * Repository class for Warehouse Product
 */
@Repository
public interface ProductRepo extends PagingAndSortingRepository<Product, Integer> {
    List<Product> findByDetailsContaining(String searchString, Pageable pageableRequest);
    Optional<Product> findByCodeContaining(String productCode);
}
