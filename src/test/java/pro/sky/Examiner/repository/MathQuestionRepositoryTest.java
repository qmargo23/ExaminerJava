package pro.sky.Examiner.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.Examiner.domain.Question;

import java.util.Collection;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathQuestionRepositoryTest {
    private MathQuestionRepository out;

    @BeforeEach
    void beforeEach() {
        out = new MathQuestionRepository();
        out.add(new Question("123", "321"));
        out.add(new Question("234", "432"));
        out.add(new Question("345", "543"));
    }

    @Test
    void shouldReturnCorrectCollection() {
        Collection<Question> expected = Set.of(
                new Question("123", "321"),
                new Question("234", "432"),
                new Question("345", "543")
        );

        assertEquals(expected, out.getAll());
    }

    @Test
    void shouldReturnQuestionAfterAddAndCorrectCollection() {
        Question expectedQuestion = new Question("456", "654");
        Collection<Question> expectedCollection = Set.of(
                new Question("123", "321"),
                new Question("234", "432"),
                new Question("345", "543"),
                expectedQuestion
        );

        assertEquals(expectedQuestion, out.add("456", "654"));
        assertEquals(expectedCollection, out.getAll());
    }

    @Test
    void shouldReturnQuestionAfterRemoveAndCorrectCollection() {
        Question expectedQuestion = new Question("123", "321");
        Collection<Question> expectedCollection = Set.of(
                new Question("234", "432"),
                new Question("345", "543")
        );

        assertEquals(expectedQuestion, out.remove(expectedQuestion));
        assertEquals(expectedCollection, out.getAll());
    }
}
