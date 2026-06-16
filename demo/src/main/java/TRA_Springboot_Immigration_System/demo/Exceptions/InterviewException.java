package TRA_Springboot_Immigration_System.demo.Exceptions;

import org.springframework.http.HttpStatus;

public class InterviewException extends RuntimeException {

    private final HttpStatus status;

    public InterviewException(String message) {
        super(message);
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public InterviewException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

    public static InterviewException notFound(Long id) {
        return new InterviewException(HttpStatus.NOT_FOUND, "Interview With ID " + id + " Was NOT Found.");
    }

    public static InterviewException badRequest(String message) {
        return new InterviewException(HttpStatus.BAD_REQUEST, message);
    }

    public HttpStatus getStatus() {
        return status;
    }
}
