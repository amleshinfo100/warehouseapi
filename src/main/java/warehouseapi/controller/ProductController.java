package warehouseapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import warehouseapi.dto.ProductDto;
import warehouseapi.dto.SearchRequestDto;
import warehouseapi.dto.SearchResultDto;
import warehouseapi.service.ProductService;

import javax.validation.Valid;

/**
 * This controller exposes product related endpoints
 */
@RestController
@RequestMapping("/product")
@Validated
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * This method exposes endpoint to enable saving products in a warehouse
     * @param productDto Product request object
     * @return Saved Product in database
     */
    @Operation(summary = "create product")
    @PostMapping
    public ProductDto save(@RequestBody @Valid ProductDto productDto) {
        return this.productService.save(productDto);
    }

    /**
     * This method exposes endpoint to enable search of products in a warehouse with pagination
     * @param searchRequestDto Serach request object
     * @return Serach result object
     */
    @Operation(summary = "search product with pagination")
    @PostMapping("/search")
    public SearchResultDto searchProducts(@RequestBody @Valid SearchRequestDto searchRequestDto){
        return productService.searchProducts(searchRequestDto);
    }
}
