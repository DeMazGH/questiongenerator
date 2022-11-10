package pro.sky.question_generator.service;

import org.springframework.stereotype.Service;
import pro.sky.question_generator.model.Question;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions;

    public JavaQuestionService() {
        this.questions = new HashSet<>();
    }

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        questions.add(newQuestion);

        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Set.copyOf(questions);
    }

    @Override
    public Question getRandomQestion() {
        Random random = new Random();
        Question[] questionArray = questions.toArray(new Question[0]);
        return questionArray[random.nextInt(questions.size())];

    }
}
