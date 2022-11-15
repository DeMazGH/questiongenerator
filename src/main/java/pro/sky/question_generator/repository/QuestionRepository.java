package pro.sky.question_generator.repository;

import pro.sky.question_generator.model.Question;

import java.util.Collection;

public interface QuestionRepository {

    void init();

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();

}
