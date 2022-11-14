package pro.sky.question_generator.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.question_generator.exeptions.ServiceDoesNotHaveEnoughQuestionsException;
import pro.sky.question_generator.model.Question;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static pro.sky.question_generator.service.ServiceConstant.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    private ExaminerService out;
    @Mock
    private QuestionService questionServiceMock;
    Set<Question> questionSet;

    @BeforeEach
    public void setUp() {
        out = new ExaminerServiceImpl(questionServiceMock);

        questionSet = new HashSet<>();
        questionSet.add(OBJ_QUESTION_1);
        questionSet.add(OBJ_QUESTION_2);
        questionSet.add(OBJ_QUESTION_3);
        questionSet.add(OBJ_QUESTION_4);
        questionSet.add(OBJ_QUESTION_5);
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

        Mockito.when(questionServiceMock.getRandomQuestion()).thenReturn(getRandomQuestion());

        Collection<Question> actual = out.getQuestions(AMOUNT_5);
        assertEquals(AMOUNT_5, actual.size());
    }

    private Question getRandomQuestion() {
        Question[] questionArray = questionSet.toArray(new Question[0]);
        Random random = new Random();
        return questionArray[random.nextInt(questionSet.size())];
    }
}