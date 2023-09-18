package pro.sky.Examiner.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.Examiner.domain.Question;
import pro.sky.Examiner.exception.NoQuestionsException;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {
    private QuestionService out;

    @BeforeEach
    void beforeEach() {
        out = new JavaQuestionService();
        out.add(new Question("question1", "answer1"));
    }

    @Test
    void shouldReturnCollectionWithQuestions() {
        Set<Question> expected = new HashSet<>(Set.of(
                new Question("question1", "answer1")));
        assertIterableEquals(expected, out.getAll());
    }

    @Test
    void doesNotHaveSameHashCodes_Add_01() {
        Set<Question> expected = new HashSet<>(Set.of(
                new Question("question4", "answer4")));
        assertThat(out)
                .doesNotHaveSameHashCodeAs(expected);
    }

    @Test
    void test_Add() {
        var actualQuestion = out.getAll();

        assertThat(actualQuestion).containsExactly(
                new Question("question1", "answer1"));
    }

    @Test
    void assertNotEquals_Add_02() {
        Set<Question> expected = new HashSet<>(Set.of(
                new Question("question4", "answer4")));
        Assertions.assertNotEquals(expected, out.getAll());
    }

    @Test
    void Add() {
        Set<Question> expected = new HashSet<>(Set.of(
                new Question("question4", "answer4")));
        Assertions.assertNotNull(expected);
    }

    @Test
    void getAllCopyUnmodifiable() {
        assertThrows(UnsupportedOperationException.class,
                () ->
                        out.getAll().add(new Question("question2", "answer2")));
    }

    @Test
    void testRemove() {
//    assertThat(out.remove(new Question("question1", "answer1"))).isNotNull();
        assertThat(out.remove(new Question("q1", "a1"))).isNull();
        assertThat(out.remove(new Question("question1", "answer1"))).isEqualTo(new Question("question1", "answer1"));
    }

    @Test
    void testRandomQuestionWhenEmpty() {
        out.remove(new Question("question1", "answer1"));

        assertThrows(NoQuestionsException.class, () -> out.getRandomQuestion());
    }

    @Test
    void testRandomQuestionWhenAddWithRandom() {
        assertThat(out.getAll().size()).isEqualTo(1);
        assertThat(out.getRandomQuestion()).isEqualTo(new Question("question1", "answer1"));
    }

    @Test
    void testRandomQuestionWhenAddAnyAmountWithRandom() {
        out.add("question2", "answer2");
        out.add("question3", "answer3");
        out.add("question4", "answer4");

        var allQuestions = out.getAll();
        Set<Question> actualQuestions = new HashSet<>();
        while (allQuestions.size() != actualQuestions.size()) {
            actualQuestions.add(out.getRandomQuestion());
        }
        assertThat(allQuestions).isEqualTo(actualQuestions);
    }

}