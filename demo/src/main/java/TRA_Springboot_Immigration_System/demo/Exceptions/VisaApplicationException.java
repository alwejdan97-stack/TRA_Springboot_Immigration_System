package TRA_Springboot_Immigration_System.demo.Exceptions;

import org.springframework.http.HttpStatus;

public class VisaApplicationException extends RuntimeException {

    private final HttpStatus status;

    public VisaApplicationException(String message) {
        super(message);
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public VisaApplicationException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

    public static VisaApplicationException notFound(Integer id) {
        return new VisaApplicationException(HttpStatus.NOT_FOUND, "Visa Application With ID " + id + " Was NOT Found.");
    }

    public static VisaApplicationException badRequest(String message) {
        return new VisaApplicationException(HttpStatus.BAD_REQUEST, message);
    }

    public HttpStatus getStatus() {
        return status;
    }
}
