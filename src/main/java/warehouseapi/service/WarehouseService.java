package warehouseapi.service;

import warehouseapi.dto.BoxDto;

public interface WarehouseService {
    BoxDto updateProductBox(String productCode);
}
