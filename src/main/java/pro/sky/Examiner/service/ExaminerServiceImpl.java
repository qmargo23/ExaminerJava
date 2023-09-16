package pro.sky.Examiner.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.Examiner.domain.Question;
import pro.sky.Examiner.exception.IncorrectAmountOfQuestionsException;
import pro.sky.Examiner.service.ExaminerService;
import pro.sky.Examiner.service.QuestionService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;

    public ExaminerServiceImpl(@Qualifier("javaQuestionService") QuestionService javaQuestionService,
                               @Qualifier("mathQuestionService") QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > javaQuestionService.getAll().size() + mathQuestionService.getAll().size()) {
            throw new IncorrectAmountOfQuestionsException();
        }
        Set<Question> questions = new HashSet<>();

        while (questions.size() < amount) {
            questions.add(javaQuestionService.getRandomQuestion());
            if (questions.size() < amount) {
                questions.add(mathQuestionService.getRandomQuestion());
            }
        }
        return questions;
    }
}
