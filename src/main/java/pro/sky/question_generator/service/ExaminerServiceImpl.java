package pro.sky.question_generator.service;

import org.springframework.stereotype.Service;
import pro.sky.question_generator.exeptions.ServiceDoesNotHaveEnoughQuestionsException;
import pro.sky.question_generator.model.Question;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > questionService.getAll().size() || amount < 0) {
            throw new ServiceDoesNotHaveEnoughQuestionsException("В сервисе нет запрошенного количества вопросов");
        }

        Collection<Question> questions = new ArrayList<>();

        while (amount > questions.size()) {
            questions.add(questionService.getRandomQuestion());
        }

        return questions;
    }
}
