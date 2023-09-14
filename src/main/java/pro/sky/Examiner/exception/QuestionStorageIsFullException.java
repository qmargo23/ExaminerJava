package pro.sky.Examiner.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

public class QuestionStorageIsFullException extends HttpStatusCodeException {

    public QuestionStorageIsFullException(String message) {

        super(HttpStatus.BAD_REQUEST, message);

    }
}