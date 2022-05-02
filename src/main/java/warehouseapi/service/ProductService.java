package warehouseapi.service;

import warehouseapi.dto.ProductDto;
import warehouseapi.dto.SearchRequestDto;
import warehouseapi.dto.SearchResultDto;

/**
 * service class for Warehouse Product
 */
public interface ProductService {
    ProductDto save(ProductDto productDto);
    SearchResultDto searchProducts(SearchRequestDto searchString);
}
