package pro.sky.Examiner.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.Examiner.domain.Question;
import pro.sky.Examiner.exception.IncorrectAmountOfQuestionsException;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionService javaQuestionServiceMock;
    @InjectMocks
    private ExaminerServiceImpl examinerServiceMock;

    List<Question> testCollection = new ArrayList<>();

    @BeforeEach
    void addTestSet() {
        testCollection.add(new Question("Вопрос6", "ответ6"));
        testCollection.add(new Question("Вопрос7", "ответ7"));
        testCollection.add(new Question("Вопрос8", "ответ8"));
        testCollection.add(new Question("Вопрос9", "ответ9"));
    }

    @Test
    void IncorrectAmountException() {
        assertEquals("IncorrectAmount", assertThrows(IncorrectAmountOfQuestionsException.class,() -> examinerServiceMock.getQuestions(javaQuestionServiceMock.getAll().size() + 1)).getMessage());
    }

    @Test
    void getQuestions() {
        int actualSize = 3;
        int resultSize = 3;
        Random random = new Random();
        Set<Question> setRandomQuestionTest = new HashSet<>();
        while (setRandomQuestionTest.size() < resultSize) {
            int r = random.nextInt(testCollection.size());
            setRandomQuestionTest.add(testCollection.get(r));
        }
        assertEquals(actualSize, setRandomQuestionTest.size());
    }
}
