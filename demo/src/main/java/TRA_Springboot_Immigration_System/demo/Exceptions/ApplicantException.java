package TRA_Springboot_Immigration_System.demo.Exceptions;

import org.springframework.http.HttpStatus;

public class ApplicantException extends RuntimeException {

    private final HttpStatus status;

    public ApplicantException(String message) {
        super(message);
    }

    public CourseException(String message) {
        super(message);
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public CourseException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

    public static CourseException notFound(Integer id) {
        return new CourseException(HttpStatus.NOT_FOUND, "Course with ID " + id + " was not found.");
    }

    public static CourseException badRequest(String message) {
        return new CourseException(HttpStatus.BAD_REQUEST, message);
    }

    public HttpStatus getStatus() {
        return status;
    }
}
