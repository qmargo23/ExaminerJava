package pro.sky.Examiner.service;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.Examiner.domain.Question;
import pro.sky.Examiner.repository.QuestionRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class MathQuestionService implements QuestionService {
    private final QuestionRepository questions;

    public MathQuestionService(@Qualifier("mathQuestionRepository") QuestionRepository questions) {
        this.questions = questions;
    }

    @Override
    public Question add(String question, String answer) {
        return questions.add(question, answer);
    }

    @Override
    public Question add(Question question) {
        return questions.add(question);
    }

    @Override
    public Question remove(Question question) {
        return questions.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return questions.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        int max = questions.getAll().size();
        List<Question> questionsList = new ArrayList<>(questions.getAll());
        return questionsList.get((int) (Math.random() * max));
    }
}

