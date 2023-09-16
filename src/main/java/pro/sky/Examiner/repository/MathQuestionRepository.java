package pro.sky.Examiner.repository;

import org.springframework.stereotype.Repository;
import pro.sky.Examiner.domain.Question;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Repository
public class MathQuestionRepository implements QuestionRepository {
    private final Set<Question> questions = new HashSet<>();

    @PostConstruct
    public void init() {
        questions.add(new Question("question1", "111"));
        questions.add(new Question("question2", "222"));
        questions.add(new Question("question3", "333"));
    }

    @Override
    public Question add(String question, String answer) {
        Question item = new Question(question, answer);
        questions.add(item);
        return item;
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
    public Collection<Question> getAll() {
        return questions;
    }
}

