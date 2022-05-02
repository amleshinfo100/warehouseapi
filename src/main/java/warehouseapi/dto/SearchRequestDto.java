package warehouseapi.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;

/**
 * This class represents the incoming search request
 * It contains needed info for a paginated search
 */
@Data
public class SearchRequestDto {

    private static final String INVALID_PAGE_IDX = "Invalid Page Index value";
    private static final String INVALID_RANGE = "Invalid Range";
    private static final String SEARCH_REGEX_ERR_MSG = "must not contain special characters";
    /**
     * Page number
     */
    @PositiveOrZero (message = INVALID_PAGE_IDX)
    private int pageIndex;

    /**
     * Number of rows per page
     */
    @PositiveOrZero (message = INVALID_PAGE_IDX)
    @Max(value = 10 , message = INVALID_RANGE)
    private int pageSize;

    /**
     * search criteria string
     */
    @Pattern(regexp = "[a-zA-Z0-9]+", message = SEARCH_REGEX_ERR_MSG)
    private String searchString;
}
