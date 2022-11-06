package pro.sky.question_generator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.question_generator.model.Question;
import pro.sky.question_generator.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("exam/java")
public class JavaQuestionController {

    QuestionService service;

    public JavaQuestionController(QuestionService service) {
        this.service = service;
    }

    @GetMapping("/add?question=QuestionText&answer=QuestionAnswer")
    public Question addQuestion(String question, String answer) {
        return null;
    }

    @GetMapping("remove?question=QuestionText&answer=QuestionAnswer")
    public Question removeQuestion(String question, String answer) {
        return null;
    }

    @GetMapping()
    public Collection<Question> getQuestions() {
        return null;
    }
}
