package warehouseapi.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

/**
 * This class Handles various exceptions that occur in api
 * log error details and create custom error response
 */
@RestControllerAdvice
@Slf4j
public class RestExceptionHandler {

    private static final String ERROR_CAUSE = "Error Cause : {} ";
    private static final String DB_ERR = "Database Error";
    private static final String DB_ERR_MSG = "Error occurred in Database operations";
    private static final String RESOURCE_ERR_MSG = "Resource not found";
    private static final String RESOURCE_DUP_MSG = "Resource already mapped";
    private static final String CONSTRAINT_VIOLATION_ERR = "Constraint Violation";

    /**
    * @param ex Invalid field values caught as MethodArgumentNotValidException
    * @return custom error response
    */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        log.error(ERROR_CAUSE,ex.getLocalizedMessage());
        return new ResponseEntity<>(new ErrorResponse(errors),HttpStatus.BAD_REQUEST);
    }

    /**
     * @param ex Data Integrity violation exception
     * @return custom error response
     */
    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put(DB_ERR,DB_ERR_MSG);
        log.error(ERROR_CAUSE,ex.getMessage());
        return new ResponseEntity<>(new ErrorResponse(errors),HttpStatus.BAD_REQUEST);
    }


    /**
     * @param ex Resource not found exception
     * @return custom error response
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put(DB_ERR,RESOURCE_ERR_MSG);
        log.error(ERROR_CAUSE,ex.getMessage());
        return new ResponseEntity<>(new ErrorResponse(errors),HttpStatus.NOT_FOUND);
    }

    /**
     * @param ex Invalid data access exception
     * @return custom error response
     */
    @ExceptionHandler(InvalidDataAccessApiUsageException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorResponse> handleInvalidDataAccessApiUsageException(InvalidDataAccessApiUsageException ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put(DB_ERR,DB_ERR_MSG);
        log.error(ERROR_CAUSE,ex.getMessage());
        return new ResponseEntity<>(new ErrorResponse(errors),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * @param ex Constraint violation exception
     * @return custom error response
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorResponse> handleConstraintViolationException(ConstraintViolationException ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put(ERROR_CAUSE,CONSTRAINT_VIOLATION_ERR);
        log.error(ERROR_CAUSE,ex.getLocalizedMessage());
        return new ResponseEntity<>(new ErrorResponse(errors),HttpStatus.BAD_REQUEST);
    }

    /**
     * @param ex Resource already exist exception
     * @return custom error response
     */
    @ExceptionHandler(ResourceAlreadyExistException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public ResponseEntity<ErrorResponse> handleResourceAlreadyExistException(ResourceAlreadyExistException ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put(ERROR_CAUSE,RESOURCE_DUP_MSG);
        log.error(ERROR_CAUSE,ex.getLocalizedMessage());
        return new ResponseEntity<>(new ErrorResponse(errors),HttpStatus.NOT_ACCEPTABLE);
    }


}


