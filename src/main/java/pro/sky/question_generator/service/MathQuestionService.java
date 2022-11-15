package pro.sky.question_generator.service;

import org.springframework.stereotype.Service;
import pro.sky.question_generator.model.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class MathQuestionService implements QuestionService {

    private final Set<Question> mathQuestions;
    private final Random random = new Random();

    public MathQuestionService() {
        this.mathQuestions = new HashSet<>();
    }

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        mathQuestions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        mathQuestions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Set.copyOf(mathQuestions);
    }

    @Override
    public Question getRandomQuestion() {
        Question[] questionArray = mathQuestions.toArray(new Question[0]);
        return questionArray[random.nextInt(mathQuestions.size())];
    }
}
