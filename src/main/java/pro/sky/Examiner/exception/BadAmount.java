package pro.sky.Examiner.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

public class BadAmount extends HttpStatusCodeException {
    public BadAmount(String message) {

        super(HttpStatus.BAD_REQUEST, message);

    }
}
