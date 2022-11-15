package pro.sky.question_generator.service;

import org.springframework.stereotype.Service;
import pro.sky.question_generator.model.Question;
import pro.sky.question_generator.repository.JavaQuestionRepository;
import pro.sky.question_generator.repository.QuestionRepository;

import java.util.Collection;
import java.util.Random;

@Service
public class JavaQuestionService implements QuestionService {

    private final QuestionRepository questionRepository = new JavaQuestionRepository();

    private final Random random = new Random();

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        return questionRepository.add(newQuestion);
    }

    @Override
    public Question add(Question question) {
        return questionRepository.add(question);
    }

    @Override
    public Question remove(Question question) {
        return questionRepository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return questionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        Question[] questionArray = getAll().toArray(new Question[0]);
        return questionArray[random.nextInt(getAll().size())];
    }
}
