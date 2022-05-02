package warehouseapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import warehouseapi.model.Box;
import warehouseapi.service.BoxService;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BoxController.class)
class BoxControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BoxService boxService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createBoxes() throws Exception {
        mockMvc.perform( MockMvcRequestBuilders
                        .post("/boxes")
                        .content(asJsonString(new Box()))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}