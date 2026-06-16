package TRA_Springboot_Immigration_System.demo.Exceptions;

import org.springframework.http.HttpStatus;

public class CenterException extends RuntimeException {

    private final HttpStatus status;

    public CenterException(String message) {
        super(message);
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public CenterException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }
    public static CenterException notFound(Long id) {
        return new CenterException(HttpStatus.NOT_FOUND, "Center With ID " + id + " Was NOT Found.");
    }
    public static CenterException badRequest(String message) {
        return new CenterException(HttpStatus.BAD_REQUEST, message);
    }

    public HttpStatus getStatus() {
        return status;
    }
}
