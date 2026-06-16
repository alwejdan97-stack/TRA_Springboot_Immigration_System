package TRA_Springboot_Immigration_System.demo.Exceptions;

import org.springframework.http.HttpStatus;
import java.sql.Date;


public class ErrorResponse {
    private Date timestamp;
    private int statusCode;
    private HttpStatus status;
    private String error;
    private String message;
    private String path;

    public ErrorResponse(Date timestamp, int statusCode, HttpStatus status, String error, String message, String path) {
        this.timestamp = timestamp;
        this.statusCode = statusCode;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }
}
