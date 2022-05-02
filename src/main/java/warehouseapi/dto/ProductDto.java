package warehouseapi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 *  Data transfer object for Product
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private static final String BLANK_ERR_MSG = "Cannot be null/blank";

    @NotBlank(message = BLANK_ERR_MSG)
    private String code;
    @NotNull(message = BLANK_ERR_MSG)
    private String name;
    private String details;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long boxId;
}
