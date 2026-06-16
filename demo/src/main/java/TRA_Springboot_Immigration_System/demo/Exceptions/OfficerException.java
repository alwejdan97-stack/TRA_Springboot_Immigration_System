package TRA_Springboot_Immigration_System.demo.Exceptions;

import org.springframework.http.HttpStatus;

public class OfficerException extends RuntimeException {
    private final HttpStatus status;

    public OfficerException(String message) {
        super(message);
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public OfficerException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

    public static OfficerException notFound(Long id) {
        return new OfficerException(HttpStatus.NOT_FOUND, "Officer With ID " + id + " Was NOT Found.");
    }

    public static OfficerException badRequest(String message) {
        return new OfficerException(HttpStatus.BAD_REQUEST, message);
    }

    public HttpStatus getStatus() {
        return status;
    }
}
