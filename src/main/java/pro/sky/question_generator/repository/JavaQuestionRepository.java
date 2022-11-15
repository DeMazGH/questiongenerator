package pro.sky.question_generator.repository;

import org.springframework.stereotype.Repository;
import pro.sky.question_generator.model.Question;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Repository
public class JavaQuestionRepository implements QuestionRepository {

    private final Set<Question> questions;

    public JavaQuestionRepository() {
        this.questions = new HashSet<>();
    }

    @Override
    @PostConstruct
    public void init() {
        // здесь можно заполнить репозиторий данными сразу после его создания Spring
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
}
