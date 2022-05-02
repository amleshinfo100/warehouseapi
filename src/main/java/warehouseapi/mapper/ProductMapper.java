package warehouseapi.mapper;

import org.mapstruct.Mapper;
import warehouseapi.dto.ProductDto;
import warehouseapi.model.Product;

/**
 * Mapper for product entity and ProductDto
 */
@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDto mapProductToProductDto(Product product);
    Product mapProductDtoToProduct(ProductDto product);
}
