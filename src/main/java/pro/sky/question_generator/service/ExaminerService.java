package pro.sky.question_generator.service;

import pro.sky.question_generator.model.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);
}
