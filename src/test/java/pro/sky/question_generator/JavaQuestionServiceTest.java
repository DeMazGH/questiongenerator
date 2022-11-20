package pro.sky.question_generator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.question_generator.model.Question;
import pro.sky.question_generator.repository.QuestionRepository;
import pro.sky.question_generator.service.JavaQuestionService;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static pro.sky.question_generator.Constant.*;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {

    @InjectMocks
    private JavaQuestionService out;

    @Mock
    private QuestionRepository questionRepositoryMock;

    Set<Question> questionsSet = new HashSet<>();

    private void setupQuestionsSet() {
        questionsSet.add(OBJ_QUESTION_1);
        questionsSet.add(OBJ_QUESTION_2);
        questionsSet.add(OBJ_QUESTION_3);
        questionsSet.add(OBJ_QUESTION_4);
        questionsSet.add(OBJ_QUESTION_5);
        when(questionRepositoryMock.getAll()).thenReturn(questionsSet);
    }

    @Test
    void shouldReturnCorrectQuestionInMethodAddOneTime() {
        when(questionRepositoryMock.add(any(Question.class))).thenReturn(OBJ_QUESTION_1);
        assertEquals(OBJ_QUESTION_1, out.add(QUESTION_1, ANSWER_1));
        verify(questionRepositoryMock, only()).add(any(Question.class));
    }

    @Test
    void shouldReturnQuestionInMethodAddOneTime() {
        when(questionRepositoryMock.add(OBJ_QUESTION_2)).thenReturn(OBJ_QUESTION_2);
        assertEquals(OBJ_QUESTION_2, out.add(OBJ_QUESTION_2));
        verify(questionRepositoryMock, only()).add(OBJ_QUESTION_2);
    }

    @Test
    void shouldThrowIllegalArgumentExceptionInMethodAdd() {
        assertThrows(IllegalArgumentException.class, () -> out.add(QUESTION_NULL, ANSWER_1));
        assertThrows(IllegalArgumentException.class, () -> out.add(QUESTION_1, ANSWER_NULL));
        assertThrows(IllegalArgumentException.class, () -> out.add(QUESTION_NULL, ANSWER_NULL));
    }

    @Test
    void shouldReturnQuestionInMethodRemoveOneTime() {
        when(questionRepositoryMock.remove(OBJ_QUESTION_2)).thenReturn(OBJ_QUESTION_2);
        assertEquals(OBJ_QUESTION_2, out.remove(OBJ_QUESTION_2));
        verify(questionRepositoryMock, only()).remove(OBJ_QUESTION_2);
    }

    @Test
    void shouldReturnCorrectCollectionOfQuestionInMethodGetAllOneTime() {
        setupQuestionsSet();
        assertIterableEquals(questionsSet, out.getAll());
        verify(questionRepositoryMock, only()).getAll();
    }

    @Test
    void shouldReturnQuestionInMethodGetRandomQuestion() {
        setupQuestionsSet();
        assertTrue(out.getAll().contains(out.getRandomQuestion()));
    }
}