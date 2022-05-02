package warehouseapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import warehouseapi.dto.BoxDto;
import warehouseapi.service.WarehouseService;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

/**
 * This controller exposes product and box mapper endpoint
 */
@RestController
@Validated
public class WarehouseController {

    private final WarehouseService warehouseService;
    private final static String PRD_REGEX_ERR_MSG = "must not contain special characters";

    @Autowired
    public WarehouseController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @Operation(summary = "update product with box")
    @PutMapping("/productbox/{productCode}")
    public ResponseEntity<BoxDto> updateProductBox(@PathVariable @Valid @Pattern(regexp = "[a-zA-Z0-9]+", message = PRD_REGEX_ERR_MSG) String productCode){
        return ResponseEntity.ok().body(warehouseService.updateProductBox(productCode));
    }

}
