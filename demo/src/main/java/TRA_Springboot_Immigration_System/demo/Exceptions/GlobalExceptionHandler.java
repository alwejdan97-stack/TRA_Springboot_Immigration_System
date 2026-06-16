package TRA_Springboot_Immigration_System.demo.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import java.util.Date;

@RestControllerAdvice
public class GlobalExceptionHandler extends RuntimeException {
    public GlobalExceptionHandler(String message) {
        super(message);
    }

    @ExceptionHandler(GenericException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFound(GenericException ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.NOT_FOUND ,
                HttpStatus.NOT_FOUND.value(),
                "Hello",
                ex.getMessage(),
                request.getDescription(false).replace("uri=", ""));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(Exception ex, WebRequest request) {
        ErrorResponse errorDetails = new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR,
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Internal Server Error",
                "An unexpected error occurred on the server.",
                request.getDescription(false).replace("uri=", "")
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDetails);
    }

    @ExceptionHandler(ApplicantException.class)
    public ResponseEntity<ErrorResponse> handleApplicantException(ApplicantException exception, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        HttpStatus status = exception.getStatus();
        errorResponse.setStatus(status);
        errorResponse.setStatusCode(status.value());
        errorResponse.setError(status.getReasonPhrase());
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setTimestamp(new Date());
        return ResponseEntity.status(status).body(errorResponse);
    }

    @ExceptionHandler(InterviewException.class)
    public ResponseEntity<ErrorResponse> handleInterviewException(InterviewException exception, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        HttpStatus status = exception.getStatus();
        errorResponse.setStatus(status);
        errorResponse.setStatusCode(status.value());
        errorResponse.setError(status.getReasonPhrase());
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setTimestamp(new Date());
        return ResponseEntity.status(status).body(errorResponse);
    }

    @ExceptionHandler(OfficerException.class)
    public ResponseEntity<ErrorResponse> handleOfficerException(OfficerException exception, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        HttpStatus status = exception.getStatus();
        errorResponse.setStatus(status);
        errorResponse.setStatusCode(status.value());
        errorResponse.setError(status.getReasonPhrase());
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setTimestamp(new Date());
        return ResponseEntity.status(status).body(errorResponse);
    }

    @ExceptionHandler(VisaApplicationException.class)
    public ResponseEntity<ErrorResponse> handleVisaApplicationException(VisaApplicationException exception, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        HttpStatus status = exception.getStatus();
        errorResponse.setStatus(status);
        errorResponse.setStatusCode(status.value());
        errorResponse.setError(status.getReasonPhrase());
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setTimestamp(new Date());
        return ResponseEntity.status(status).body(errorResponse);
    }
}
