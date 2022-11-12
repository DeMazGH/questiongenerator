package pro.sky.question_generator.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ServiceDoesNotHaveEnoughQuestionsExeption extends RuntimeException{

    public ServiceDoesNotHaveEnoughQuestionsExeption() {
    }

    public ServiceDoesNotHaveEnoughQuestionsExeption(String message) {
        super(message);
    }

    public ServiceDoesNotHaveEnoughQuestionsExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceDoesNotHaveEnoughQuestionsExeption(Throwable cause) {
        super(cause);
    }

    public ServiceDoesNotHaveEnoughQuestionsExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
