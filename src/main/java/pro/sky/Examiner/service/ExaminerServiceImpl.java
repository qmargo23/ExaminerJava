package pro.sky.Examiner.service;

import org.springframework.stereotype.Service;
import pro.sky.Examiner.domain.Question;
import pro.sky.Examiner.exception.BadAmount;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService{
    private Random random;
    private QuestionService questionService;

    ExaminerServiceImpl(QuestionService questionService) {
        this.questionService= questionService;
    }
    @Override
    public Collection<Question> getQuestions(int amount) {
        int size= questionService.getSize();

        System.out.println(size);

        if (amount>size) {
            throw new BadAmount("Задано большое число");
        }
        Set<Question> generatedQuestions = new HashSet<>();

        while (generatedQuestions.size() < amount) {
            generatedQuestions.add(questionService.getRandomQuestion());
        }
        return generatedQuestions;
    }
}
