package ar.com.fernandoalvarez.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundExceptionHandling(ResourceNotFoundException exception,
                                                               WebRequest request) {
        final ErrorDetails errorDetails = new ErrorDetails(
                new Date(),
                exception.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND,
                exception.getErrorCode(),
                request.getDescription(false),
                exception.getStackTrace());
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResourceBadRequestException.class)
    public ResponseEntity<?> resourceBadRequestHandling(ResourceBadRequestException exception, WebRequest request) {
        final ErrorDetails errorDetails = new ErrorDetails(
                new Date(),
                exception.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST,
                exception.getErrorCode(),
                request.getDescription(false),
                exception.getStackTrace());
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceForbiddenException.class)
    public ResponseEntity<?> resourceForbiddenHandling(ResourceForbiddenException exception, WebRequest request) {
        final ErrorDetails errorDetails = new ErrorDetails(
                new Date(),
                exception.getMessage(),
                HttpStatus.FORBIDDEN.value(),
                HttpStatus.FORBIDDEN,
                exception.getErrorCode(),
                request.getDescription(false),
                exception.getStackTrace());
        return new ResponseEntity<>(errorDetails, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(ResourceUnauthorizedException.class)
    public ResponseEntity<?> resourceUnauthorizedHandling(ResourceUnauthorizedException exception, WebRequest request) {
        final ErrorDetails errorDetails = new ErrorDetails(
                new Date(),
                exception.getMessage(),
                HttpStatus.UNAUTHORIZED.value(),
                HttpStatus.UNAUTHORIZED,
                exception.getErrorCode(),
                request.getDescription(false),
                exception.getStackTrace());
        return new ResponseEntity<>(errorDetails, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(ResourceValidationException.class)
    public ResponseEntity<?> resourceValidationExceptionHandling(ResourceValidationException exception, WebRequest request) {
        final ErrorDetails errorDetails = new ErrorDetails(
                new Date(),
                exception.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST,
                exception.getErrorCode(),
                request.getDescription(false),
                exception.getStackTrace());
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalExceptionHandling(Exception exception, WebRequest request) {
        final ErrorDetails errorDetails = new ErrorDetails(
                new Date(),
                exception.getMessage(),
                500,
                HttpStatus.INTERNAL_SERVER_ERROR,
                "INTERNAL_SERVER_ERROR",
                request.getDescription(false),
                exception.getStackTrace());
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
