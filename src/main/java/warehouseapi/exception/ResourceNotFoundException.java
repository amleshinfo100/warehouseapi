package warehouseapi.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends BaseRuntimeException {

    public ResourceNotFoundException(String name) {
        super("Resource " + name + " not found", HttpStatus.NOT_FOUND);
    }
}

