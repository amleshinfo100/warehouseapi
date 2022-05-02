package warehouseapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import warehouseapi.dto.BoxDto;
import warehouseapi.model.Box;
import warehouseapi.service.BoxService;

@RestController
public class BoxController {

    private final BoxService warehouseService;

    @Autowired
    public BoxController(BoxService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @Operation(summary = "create boxes and attach products")
    @PostMapping("/boxes")
    public BoxDto createBoxes(@RequestBody Box box){
       return  warehouseService.createWarehouseBoxes(box);
    }

}
