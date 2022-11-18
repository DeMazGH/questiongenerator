package pro.sky.question_generator;

import org.junit.jupiter.api.Test;
import pro.sky.question_generator.model.Question;
import pro.sky.question_generator.repository.MathQuestionRepository;
import pro.sky.question_generator.repository.QuestionRepository;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.question_generator.Constant.*;

class MathQuestionRepositoryTest {

    private final QuestionRepository out = new MathQuestionRepository();

    @Test
    void shouldReturnCorrectQuestionInMethodAdd() {
        assertEquals(OBJ_QUESTION_2, out.add(OBJ_QUESTION_2));
    }

    @Test
    void shouldReturnTrueInMethodAdd() {
        out.add(OBJ_QUESTION_2);
        assertTrue(out.getAll().contains(OBJ_QUESTION_2));
    }

    @Test
    void shouldReturnQuestionInMethodRemove() {
        out.add(OBJ_QUESTION_2);
        assertEquals(OBJ_QUESTION_2, out.remove(OBJ_QUESTION_2));
    }

    @Test
    void shouldReturnFalseInMethodRemove() {
        out.add(OBJ_QUESTION_1);
        out.remove(OBJ_QUESTION_1);
        assertFalse(out.getAll().contains(OBJ_QUESTION_1));
    }

    @Test
    void shouldReturnCorrectCollectionOfQuestionInMethodGetAll() {
        Set<Question> expected = new HashSet<>();
        expected.add(OBJ_QUESTION_1);
        expected.add(OBJ_QUESTION_4);
        expected.add(OBJ_QUESTION_5);

        out.add(OBJ_QUESTION_5);
        out.add(OBJ_QUESTION_4);
        out.add(OBJ_QUESTION_1);
        out.add(OBJ_QUESTION_1);

        assertEquals(expected, out.getAll());
    }
}