package pro.sky.question_generator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import pro.sky.question_generator.exeptions.ServiceDoesNotHaveEnoughQuestionsException;
import pro.sky.question_generator.model.Question;
import pro.sky.question_generator.service.ExaminerServiceImpl;
import pro.sky.question_generator.service.JavaQuestionService;
import pro.sky.question_generator.service.MathQuestionService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.question_generator.Constant.*;

@ExtendWith(MockitoExtension.class)
//@MockitoSettings(strictness = Strictness.LENIENT)
class ExaminerServiceImplTest {

    @InjectMocks
    private ExaminerServiceImpl out;

    @Mock
    private JavaQuestionService javaQuestionServiceMock;

    @Mock
    private MathQuestionService mathQuestionServiceMock;

    private final Set<Question> javaQuestionSet = new HashSet<>();
    private final Set<Question> mathQuestionSet = new HashSet<>();

    @BeforeEach
    public void setUp() {
        javaQuestionSet.add(OBJ_QUESTION_1);
        javaQuestionSet.add(OBJ_QUESTION_2);
        javaQuestionSet.add(OBJ_QUESTION_3);
        Mockito.when(javaQuestionServiceMock.getAll()).thenReturn(javaQuestionSet);

        mathQuestionSet.add(OBJ_QUESTION_4);
        mathQuestionSet.add(OBJ_QUESTION_5);
        mathQuestionSet.add(OBJ_QUESTION_6);
        Mockito.when(mathQuestionServiceMock.getAll()).thenReturn(mathQuestionSet);
    }

    @Test
    void shouldThrowServiceDoesNotHaveEnoughQuestionsExceptionInMethodGetQuestions() {
        assertThrows(ServiceDoesNotHaveEnoughQuestionsException.class, () -> out.getQuestions(AMOUNT_8));
        assertThrows(ServiceDoesNotHaveEnoughQuestionsException.class, () -> out.getQuestions(AMOUNT_NEGATIVE_2));
    }

    @Test
    void shouldReturnCollectionWithCorrectSizeInMethodGetQuestions() {
        Mockito.when(javaQuestionServiceMock.getRandomQuestion()).thenReturn(OBJ_QUESTION_1, OBJ_QUESTION_3, OBJ_QUESTION_2);
        Mockito.when(mathQuestionServiceMock.getRandomQuestion()).thenReturn(OBJ_QUESTION_4, OBJ_QUESTION_6, OBJ_QUESTION_5);

        Collection<Question> expected = new HashSet<>();
        expected.add(OBJ_QUESTION_1);
        Collection<Question> actual = out.getQuestions(AMOUNT_1);
        assertEquals(expected, actual);

        expected.add(OBJ_QUESTION_4);
        expected.add(OBJ_QUESTION_3);
        actual = out.getQuestions(AMOUNT_3);
        assertEquals(expected, actual);

        expected.add(OBJ_QUESTION_6);
        expected.add(OBJ_QUESTION_2);
        expected.add(OBJ_QUESTION_5);
        actual = out.getQuestions(AMOUNT_6);
        assertEquals(expected, actual);
    }
}