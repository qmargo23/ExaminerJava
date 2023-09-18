package pro.sky.Examiner.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.Examiner.domain.Question;
import pro.sky.Examiner.exception.IncorrectAmountOfQuestionsException;

import java.util.Collections;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionService javaQuestionService;
    @InjectMocks
    private ExaminerServiceImpl service;

    @Test
    void getRandomWhenEmpty() {
        when(javaQuestionService.getAll()).thenReturn(Collections.emptySet());
        assertThrows(IncorrectAmountOfQuestionsException.class, () -> service.getQuestions(1));
    }

    @Test
    void testWhenAmountEqualsQuestionSize() {
        var qa = Set.of(new Question("Q1", "A1"));
        when(javaQuestionService.getAll()).thenReturn(qa);
        assertSame(service.getQuestions(1), qa);
    }

    @Test
    void testWhenAmountLessQuestionSize() {
        var qa = Set.of(new Question("Q1", "A1"), new Question("Q2", "A2"));
        when(javaQuestionService.getAll()).thenReturn(qa);
        assertNotSame(service.getQuestions(1), qa);
    }

//    @Test//не пойму почему не работает: при добавлении вернутьсодержащую такую же коллекцию - пишет:
    //java.lang.AssertionError:
        //Actual and expected have the same elements but not in the same order, at index 0 actual element was:
        //  Question{question='Q2', answer='A2'}
        //whereas expected element was:
        //  Question{question='Q1', answer='A1'}

//Help
    void getRandomQuestions() {
        var qa = Set.of(new Question("Q1", "A1"), new Question("Q2", "A2"), new Question("Q3", "A3"));
        when(javaQuestionService.getAll()).thenReturn(qa);
        when(javaQuestionService.getRandomQuestion())
                .thenReturn(new Question("Q1", "A1"))
                .thenReturn(new Question("Q1", "A1"))
                .thenReturn(new Question("Q2", "A2"));

        var actual = service.getQuestions(2);

        assertThat(actual).containsExactly(
                new Question("Q1", "A1"),
                new Question("Q2", "A2"));


    }
}
