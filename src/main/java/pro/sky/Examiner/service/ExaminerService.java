package pro.sky.Examiner.service;

import org.springframework.stereotype.Service;
import pro.sky.Examiner.domain.Question;

import java.util.Collection;


public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
