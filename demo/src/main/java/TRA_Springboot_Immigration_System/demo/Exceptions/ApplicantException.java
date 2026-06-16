package TRA_Springboot_Immigration_System.demo.Exceptions;

import org.springframework.http.HttpStatus;

public class ApplicantException extends RuntimeException {

    private final HttpStatus status;

    public ApplicantException(String message) {
        super(message);
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public ApplicantException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

    public static ApplicantException notFound(Long id) {
        return new ApplicantException(HttpStatus.NOT_FOUND, "Applicant With ID " + id + " Was NOT Found.");
    }

    public static ApplicantException badRequest(String message) {
        return new ApplicantException(HttpStatus.BAD_REQUEST, message);
    }

    public HttpStatus getStatus() {
        return status;
    }
}
