package pro.sky.question_generator.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ServiceDoesNotHaveEnoughQuestionsException extends RuntimeException{

    public ServiceDoesNotHaveEnoughQuestionsException() {
    }

    public ServiceDoesNotHaveEnoughQuestionsException(String message) {
        super(message);
    }

    public ServiceDoesNotHaveEnoughQuestionsException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceDoesNotHaveEnoughQuestionsException(Throwable cause) {
        super(cause);
    }

    public ServiceDoesNotHaveEnoughQuestionsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
