package pro.sky.Examiner.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.Examiner.domain.Question;
import pro.sky.Examiner.repository.QuestionRepository;

import java.util.Collection;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {
    @Mock
    private QuestionRepository questionRepositoryMock;

    @InjectMocks
    private JavaQuestionService out;

    private final Collection<Question> questions = Set.of(
            new Question("qwe", "ewq"),
            new Question("asd", "dsa"),
            new Question("zxc", "cxz")
    );

    @Test
    void shouldReturnTrueAfterRandom() {
        when(questionRepositoryMock.getAll()).thenReturn(questions);

        assertTrue(out.getAll().contains(out.getRandomQuestion()));
    }
}
