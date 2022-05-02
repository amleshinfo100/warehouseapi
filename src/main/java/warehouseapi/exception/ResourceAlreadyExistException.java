package warehouseapi.exception;

import org.springframework.http.HttpStatus;

public class ResourceAlreadyExistException extends BaseRuntimeException{
    public ResourceAlreadyExistException(String name) {
        super("Resource " + name + " not acceptable", HttpStatus.NOT_ACCEPTABLE);
    }
}
