package pro.sky.question_generator.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.question_generator.exeptions.ServiceDoesNotHaveEnoughQuestionsException;
import pro.sky.question_generator.model.Question;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static pro.sky.question_generator.service.ServiceConstant.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @InjectMocks
    private ExaminerServiceImpl out;
    @Mock
    private QuestionService questionServiceMock;
    private Set<Question> questionSet;

    @BeforeEach
    public void setUp() {
        questionSet = new HashSet<>();
        questionSet.add(OBJ_JAVA_QUESTION_1);
        questionSet.add(OBJ_JAVA_QUESTION_2);
        questionSet.add(OBJ_JAVA_QUESTION_3);
        questionSet.add(OBJ_JAVA_QUESTION_4);
        questionSet.add(OBJ_JAVA_QUESTION_5);
    }

    @Test
    void shouldThrowServiceDoesNotHaveEnoughQuestionsExceptionInMethodGetQuestions() {
        Mockito.when(questionServiceMock.getAll()).thenReturn(questionSet);
        assertThrows(ServiceDoesNotHaveEnoughQuestionsException.class, () -> out.getQuestions(AMOUNT_6));
        assertThrows(ServiceDoesNotHaveEnoughQuestionsException.class, () -> out.getQuestions(AMOUNT_NEGATIVE_2));
    }

    @Test
    void shouldReturnCollectionWithCorrectSizeInMethodGetQuestions() {
        Mockito.when(questionServiceMock.getAll()).thenReturn(questionSet);

        Mockito.when(questionServiceMock.getRandomQuestion()).thenReturn(OBJ_JAVA_QUESTION_2);
        assertEquals(AMOUNT_1, out.getQuestions(AMOUNT_1).size());

        Mockito.when(questionServiceMock.getRandomQuestion()).thenReturn(OBJ_JAVA_QUESTION_2, OBJ_JAVA_QUESTION_3, OBJ_JAVA_QUESTION_5);
        assertEquals(AMOUNT_3, out.getQuestions(AMOUNT_3).size());

        Mockito.when(questionServiceMock.getRandomQuestion()).thenReturn(OBJ_JAVA_QUESTION_2, OBJ_JAVA_QUESTION_3, OBJ_JAVA_QUESTION_5,
                OBJ_JAVA_QUESTION_1, OBJ_JAVA_QUESTION_4);
        assertEquals(AMOUNT_5, out.getQuestions(AMOUNT_5).size());
    }
}