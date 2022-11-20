package pro.sky.question_generator.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.question_generator.model.Question;
import pro.sky.question_generator.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/math")
public class MathQuestionController {

    private final QuestionService service;

    public MathQuestionController(@Qualifier("mathQuestionService") QuestionService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public Question addQuestion(
            @RequestParam ("question") String question,
            @RequestParam ("answer") String answer) {
        return service.add(question, answer);
    }

    @GetMapping("/remove")
    public Question removeQuestion(
            @RequestParam ("question") String question,
            @RequestParam ("question") String answer) {
        Question removedQuestion = new Question(question, answer);
        return service.remove(removedQuestion);
    }

    @GetMapping()
    public Collection<Question> getQuestions() {
        return service.getAll();
    }
}
