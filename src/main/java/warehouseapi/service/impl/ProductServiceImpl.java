package warehouseapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import warehouseapi.dto.ProductDto;
import warehouseapi.dto.SearchRequestDto;
import warehouseapi.dto.SearchResultDto;
import warehouseapi.mapper.ProductMapper;
import warehouseapi.model.Product;
import warehouseapi.repo.ProductRepo;
import warehouseapi.service.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;
    private final ProductMapper productMapper;
    private static final String SORT_BY_NAME = "name";

    @Autowired
    public ProductServiceImpl(ProductRepo productRepo, ProductMapper productMapper) {
        this.productRepo = productRepo;
        this.productMapper = productMapper;
    }

    @Override
    public ProductDto save(ProductDto productDto) {
        Product savedProduct = this.productRepo.save(productMapper.mapProductDtoToProduct(productDto));
        return productMapper.mapProductToProductDto(savedProduct);
    }

    public SearchResultDto searchProducts(SearchRequestDto searchRequestDto){
        Pageable pageableRequest = PageRequest.of(searchRequestDto.getPageIndex(),
                searchRequestDto.getPageSize(), Sort.by(SORT_BY_NAME));
        List<ProductDto> productDto =  productRepo.findByDetailsContaining(searchRequestDto.getSearchString(),pageableRequest)
                            .stream()
                            .map(productMapper::mapProductToProductDto)
                            .collect(Collectors.toList());
        return SearchResultDto.builder().product(productDto).build();
    }
}
