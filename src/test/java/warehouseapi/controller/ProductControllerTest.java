package warehouseapi.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import warehouseapi.dto.ProductDto;
import warehouseapi.service.ProductService;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static warehouseapi.controller.BoxControllerTest.asJsonString;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService ProductService;

    @Test
    void save() throws Exception {
        mockMvc.perform( MockMvcRequestBuilders
                        .post("/product")
                        .content(asJsonString(new ProductDto("code","name","details",1L)))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void searchProducts() {
    }
}