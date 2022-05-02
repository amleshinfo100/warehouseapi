package warehouseapi.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import warehouseapi.service.WarehouseService;

@WebMvcTest(WarehouseController.class)
class WarehouseControllerTest {

    @MockBean
    WarehouseService warehouseService;

    @Test
    void updateProductBox() {
    }
}