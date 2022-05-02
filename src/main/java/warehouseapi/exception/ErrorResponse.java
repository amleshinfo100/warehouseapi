package warehouseapi.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * Genric Error response
 */
@Data
public class ErrorResponse {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime timestamp;
    private Map<String, String> error;

   public ErrorResponse(Map<String, String> error) {
        this.timestamp = LocalDateTime.now();
        this.error = error;
    }
}
