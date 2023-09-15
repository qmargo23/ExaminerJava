package pro.sky.Examiner.service;

import org.junit.jupiter.api.Test;
import pro.sky.Examiner.domain.Question;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class JavaQuestionServiceTest {
    private final JavaQuestionService javaQuestionService = new JavaQuestionService();

    Question temp = new Question("Вопрос", "ответ");

    @Test
    void shouldReturnTrueAfterAddParameters() {
        javaQuestionService.add("Вопрос", "ответ");
        assertEquals(true, javaQuestionService.getAll().contains(temp));
    }

    @Test
    void addQuestion() {
        Question actual = javaQuestionService.add(new Question("Вопрос", "ответ"));
        assertEquals(true, javaQuestionService.getAll().contains(temp));
    }

    @Test
    void shouldReturnTrueAfterRemove() {
        addQuestion();
        javaQuestionService.remove(temp);
        assertEquals(false, javaQuestionService.getAll().contains(temp));
    }
    @Test
    void shouldReturnTrueAfterRandom() {
        assertTrue(javaQuestionService.getAll().contains(javaQuestionService.getRandomQuestion()));
    }
}