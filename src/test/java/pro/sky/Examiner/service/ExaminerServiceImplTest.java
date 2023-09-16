package pro.sky.Examiner.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.Examiner.domain.Question;
import pro.sky.Examiner.exception.IncorrectAmountOfQuestionsException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    private QuestionService javaQuestionServiceMock;

    @Mock
    private QuestionService mathQuestionServiceMock;

    private ExaminerServiceImpl out;

    @BeforeEach
    public void initOut() {
        out = new ExaminerServiceImpl(javaQuestionServiceMock, mathQuestionServiceMock);
    }

    private final Collection<Question> javaQuestions = new HashSet<>(Set.of(
            new Question("qwe", "ewq"),
            new Question("asd", "dsa"),
            new Question("zxc", "cxz")));

    private final Collection<Question> mathQuestions = new HashSet<>(Set.of(
            new Question("123", "321"),
            new Question("234", "432"),
            new Question("345", "543")));

    private final Collection<Question> questions = new HashSet<>(Set.of(
            new Question("qwe", "ewq"),
            new Question("asd", "dsa"),
            new Question("zxc", "cxz"),
            new Question("123", "321"),
            new Question("234", "432"),
            new Question("345", "543")));

    @Test
    void shouldReturnExceptionWhenAmountIncorrect() {
        when(mathQuestionServiceMock.getAll()).thenReturn(mathQuestions);
        when(javaQuestionServiceMock.getAll()).thenReturn(javaQuestions);

        assertThrows(IncorrectAmountOfQuestionsException.class, () -> out.getQuestions(7));
    }

    @Test
    void shouldReturnSetWithAmountQuestions() {
        when(mathQuestionServiceMock.getAll()).thenReturn(mathQuestions);
        when(javaQuestionServiceMock.getAll()).thenReturn(javaQuestions);
        when(javaQuestionServiceMock.getRandomQuestion()).thenReturn(
                new Question("qwe", "ewq"),
                new Question("zxc", "cxz"),
                new Question("zxc", "cxz"),
                new Question("asd", "dsa"),
                new Question("qwe", "ewq")
        );
        when(mathQuestionServiceMock.getRandomQuestion()).thenReturn(
                new Question("123", "321"),
                new Question("345", "543"),
                new Question("345", "543"),
                new Question("234", "432"),
                new Question("123", "321")
        );

        assertEquals(questions, out.getQuestions(6));
    }
}
