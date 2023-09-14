package pro.sky.Examiner.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

public class QuestionAlreadyAddedException extends HttpStatusCodeException {

    public QuestionAlreadyAddedException(String message) {

        super(HttpStatus.BAD_REQUEST, message);

    }
}

