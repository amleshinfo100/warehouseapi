package warehouseapi.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 *  Data transfer object for Search Result
 */
@Data
@Builder
public class SearchResultDto {

    private List<ProductDto> product;

}
