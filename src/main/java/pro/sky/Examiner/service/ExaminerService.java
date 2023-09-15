package pro.sky.Examiner.service;

import pro.sky.Examiner.domain.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
