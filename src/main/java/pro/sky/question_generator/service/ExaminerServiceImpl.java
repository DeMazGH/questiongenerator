package pro.sky.question_generator.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.question_generator.exeptions.ServiceDoesNotHaveEnoughQuestionsException;
import pro.sky.question_generator.model.Question;

import java.util.Collection;
import java.util.HashSet;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;

    public ExaminerServiceImpl(@Qualifier("javaQuestionService") QuestionService javaQuestionService,
                               @Qualifier("mathQuestionService") QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > javaQuestionService.getAll().size() + mathQuestionService.getAll().size() || amount < 0) {
            throw new ServiceDoesNotHaveEnoughQuestionsException("В сервисе нет запрошенного количества вопросов");
        }

        Collection<Question> questions = new HashSet<>();

        while (amount > questions.size()) {
            questions.add(javaQuestionService.getRandomQuestion());
            if (amount > questions.size()) {
                questions.add(mathQuestionService.getRandomQuestion());
            } else {
                break;
            }
        }
        return questions;
    }
}
