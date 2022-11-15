package pro.sky.question_generator.service;

import org.junit.jupiter.api.Test;
import pro.sky.question_generator.model.Question;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.question_generator.service.ServiceConstant.*;

class JavaQuestionServiceTest {

    private final QuestionService out = new JavaQuestionService();

    @Test
    void shouldReturnCorrectQuestionInMethodAdd() {
        Question actual = out.add(JAVA_QUESTION_1, JAVA_ANSWER_1);
        assertEquals(OBJ_JAVA_QUESTION_1, actual);
    }

    @Test
    void shouldReturnQuestionInMethodAdd() {
        Question actual = out.add(OBJ_JAVA_QUESTION_2);
        assertEquals(OBJ_JAVA_QUESTION_2, actual);
    }

    @Test
    void shouldReturnTrueInMethodAdd() {
        out.add(JAVA_QUESTION_1, JAVA_ANSWER_1);
        out.add(OBJ_JAVA_QUESTION_2);
        assertTrue(out.getAll().contains(OBJ_JAVA_QUESTION_1));
        assertTrue(out.getAll().contains(OBJ_JAVA_QUESTION_2));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionInMethodAdd() {
        assertThrows(IllegalArgumentException.class, () -> out.add(QUESTION_NULL, JAVA_ANSWER_1));
        assertThrows(IllegalArgumentException.class, () -> out.add(JAVA_QUESTION_1, ANSWER_NULL));
        assertThrows(IllegalArgumentException.class, () -> out.add(QUESTION_NULL, ANSWER_NULL));
    }

    @Test
    void shouldReturnQuestionInMethodRemove() {
        out.add(OBJ_JAVA_QUESTION_2);
        Question actual = out.remove(OBJ_JAVA_QUESTION_2);
        assertEquals(OBJ_JAVA_QUESTION_2, actual);
    }

    @Test
    void shouldReturnFalseInMethodRemove() {
        out.add(OBJ_JAVA_QUESTION_1);
        out.remove(OBJ_JAVA_QUESTION_1);
        assertFalse(out.getAll().contains(OBJ_JAVA_QUESTION_1));
    }

    @Test
    void shouldReturnCorrectCollectionOfQuestionInMethodGetAll() {
        Set<Question> expected = new HashSet<>();
        expected.add(OBJ_JAVA_QUESTION_1);
        expected.add(OBJ_JAVA_QUESTION_4);
        expected.add(OBJ_JAVA_QUESTION_5);

        out.add(OBJ_JAVA_QUESTION_5);
        out.add(OBJ_JAVA_QUESTION_4);
        out.add(OBJ_JAVA_QUESTION_1);
        out.add(OBJ_JAVA_QUESTION_1);

        assertEquals(expected, out.getAll());
    }

    @Test
    void shouldReturnQuestionInMethodGetRandomQuestion() {
        out.add(OBJ_JAVA_QUESTION_1);
        out.add(OBJ_JAVA_QUESTION_2);
        out.add(OBJ_JAVA_QUESTION_3);

        assertTrue(out.getAll().contains(out.getRandomQuestion()));
    }
}