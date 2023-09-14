package pro.sky.Examiner.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

public class QuestionNotFoundForRemoveException extends HttpStatusCodeException {

    public QuestionNotFoundForRemoveException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}
