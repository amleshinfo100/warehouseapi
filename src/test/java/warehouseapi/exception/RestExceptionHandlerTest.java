package warehouseapi.exception;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RestExceptionHandlerTest {

    @InjectMocks
    RestExceptionHandler restExceptionHandler;

    @Test
    void handleValidationExceptions() {    }

    @Test
    void handleDataIntegrityViolationException() {
    }

    @Test
    void handleResourceNotFoundException() {
    }

    @Test
    void handleInvalidDataAccessApiUsageException() {
    }
}