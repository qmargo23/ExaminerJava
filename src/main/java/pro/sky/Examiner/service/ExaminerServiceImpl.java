package pro.sky.Examiner.service;

import org.springframework.stereotype.Service;
import pro.sky.Examiner.domain.Question;
import pro.sky.Examiner.exception.IncorrectAmountOfQuestionsException;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        // чтобы не повторять код
        // в (amount > allQuestion.size() блоке
        // и вернуть всю колллекцию при amount == questionService.getAll().size(),
        Collection<Question> allQuestion = questionService.getAll();
        if (amount > allQuestion.size()) {
            throw new IncorrectAmountOfQuestionsException();
        }
        if (amount == allQuestion.size()) {
            return allQuestion;//вернуть сразу всю коллекцию!
        }
        Set<Question> questions = new HashSet<>(amount);
        while (questions.size() != amount) {
            questions.add(questionService.getRandomQuestion());
        }
        return questions;
    }
}
