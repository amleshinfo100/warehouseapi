package warehouseapi.service;

import warehouseapi.dto.BoxDto;
import warehouseapi.model.Box;

/**
 * service class for Warehouse boxes
 */
public interface BoxService {
    BoxDto createWarehouseBoxes(Box box);
}
