package warehouseapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import warehouseapi.dto.BoxDto;
import warehouseapi.model.Box;
import warehouseapi.service.BoxService;

@RestController
public class BoxController {

    private final BoxService boxService;

    @Autowired
    public BoxController(BoxService boxService) {
        this.boxService = boxService;
    }

    @Operation(summary = "create boxes and attach products")
    @PostMapping("/boxes")
    public ResponseEntity<BoxDto> createBoxes(@RequestBody Box box){
       return  ResponseEntity.ok().body(boxService.createWarehouseBoxes(box));
    }

}
