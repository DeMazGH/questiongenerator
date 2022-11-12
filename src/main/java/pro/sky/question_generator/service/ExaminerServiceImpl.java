package pro.sky.question_generator.service;

import org.springframework.stereotype.Service;
import pro.sky.question_generator.exeptions.ServiceDoesNotHaveEnoughQuestionsExeption;
import pro.sky.question_generator.model.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    Random random;  //Зачем?????????
    QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > questionService.getAll().size()) {
            throw new ServiceDoesNotHaveEnoughQuestionsExeption("В сервисе нет запрошенного количества вопросов");
        }

        Collection<Question> questions = new HashSet<>();

        while (amount > questions.size()) {
            questions.add(questionService.getRandomQuestion());
        }

        return questions;
    }
}
