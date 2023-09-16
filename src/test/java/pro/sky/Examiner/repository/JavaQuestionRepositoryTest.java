package pro.sky.Examiner.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.Examiner.domain.Question;

import java.util.Collection;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavaQuestionRepositoryTest {
    private JavaQuestionRepository out;

    @BeforeEach
    void beforeEach() {
        out = new JavaQuestionRepository();
        out.add(new Question("qwe", "ewq"));
        out.add(new Question("asd", "dsa"));
        out.add(new Question("zxc", "cxz"));
    }

    @Test
    void shouldReturnCorrectCollection() {
        Collection<Question> expected = Set.of(
                new Question("qwe", "ewq"),
                new Question("asd", "dsa"),
                new Question("zxc", "cxz")
        );

        assertEquals(expected, out.getAll());
    }

    @Test
    void shouldReturnQuestionAfterAddAndCorrectCollection() {
        Question expectedQuestion = new Question("iop", "poi");
        Collection<Question> expectedCollection = Set.of(
                new Question("qwe", "ewq"),
                new Question("asd", "dsa"),
                new Question("zxc", "cxz"),
                expectedQuestion
        );

        assertEquals(expectedQuestion, out.add("iop", "poi"));
        assertEquals(expectedCollection, out.getAll());
    }

    @Test
    void shouldReturnQuestionAfterRemoveAndCorrectCollection() {
        Question expectedQuestion = new Question("qwe", "ewq");
        Collection<Question> expectedCollection = Set.of(
                new Question("asd", "dsa"),
                new Question("zxc", "cxz")
        );

        assertEquals(expectedQuestion, out.remove(expectedQuestion));
        assertEquals(expectedCollection, out.getAll());
    }
}
