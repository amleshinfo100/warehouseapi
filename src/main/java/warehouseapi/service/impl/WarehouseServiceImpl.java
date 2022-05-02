package warehouseapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import warehouseapi.dto.BoxDto;
import warehouseapi.exception.ResourceAlreadyExistException;
import warehouseapi.exception.ResourceNotFoundException;
import warehouseapi.mapper.BoxMapper;
import warehouseapi.model.Box;
import warehouseapi.model.Product;
import warehouseapi.repo.BoxRepo;
import warehouseapi.repo.ProductRepo;
import warehouseapi.service.WarehouseService;

import java.util.HashSet;
import java.util.Set;

/**
 *
 */
@Service
public class WarehouseServiceImpl implements WarehouseService {

    private final ProductRepo productRepo;
    private final BoxRepo boxRepo;
    private final BoxMapper boxMapper;

    @Autowired
    public WarehouseServiceImpl(ProductRepo productRepo, BoxRepo boxRepo, BoxMapper boxMapper) {
        this.productRepo = productRepo;
        this.boxRepo = boxRepo;
        this.boxMapper = boxMapper;
    }

    @Override
    public BoxDto updateProductBox(String productCode) {
        Product product = productRepo.findByCodeContaining(productCode)
                .orElseThrow(() -> new ResourceNotFoundException(productCode));
        if(product!=null && null==product.getBoxId()){
            Set<Product> products = new HashSet<>();
            Box box = new Box();
            products.add(product);
            box.setProducts(products);
            return boxMapper.mapBoxToBoxDto(boxRepo.save(box));
        }else {
            throw new ResourceAlreadyExistException(productCode);
        }
    }
}
