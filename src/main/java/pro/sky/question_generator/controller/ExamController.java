package pro.sky.question_generator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.question_generator.model.Question;
import pro.sky.question_generator.service.ExaminerService;

import java.util.Collection;

@RestController
public class ExamController {

    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/get_questions")
    public Collection<Question> getQuestions(@RequestParam ("amount") int amount) {
        return examinerService.getQuestions(amount);
    }
}
