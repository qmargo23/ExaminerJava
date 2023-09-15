package pro.sky.Examiner.service;

import org.springframework.stereotype.Service;
import pro.sky.Examiner.domain.Question;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private final Set<Question> questions = new HashSet<>();

    public JavaQuestionService() {
        questions.add(new Question("вопрос_01", "ответ_01"));
        questions.add(new Question("вопрос_02", "ответ_02"));
        questions.add(new Question("вопрос_03", "ответ_03"));
    }

    @Override
    public Question add(String question, String answer) {
        Question value = new Question(question, answer);
        questions.add(value);
        return value;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Set<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> listQuestion = new ArrayList<>(questions);
        Random random = new Random();
        int r = random.nextInt(questions.size());
        return listQuestion.get(r);
    }
}

