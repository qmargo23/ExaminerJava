package pro.sky.Examiner.service;

import org.springframework.stereotype.Service;
import pro.sky.Examiner.domain.Question;
import pro.sky.Examiner.exception.NoQuestionsException;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
//    private final List<Question> questions = new ArrayList<>();/////для тестов
    private final Set<Question> questions = new HashSet<>();
    private final Random random = new Random();

//    public JavaQuestionService() {
//        questions.add(new Question("вопрос_01", "ответ_01"));
//        questions.add(new Question("вопрос_02", "ответ_02"));
//        questions.add(new Question("вопрос_03", "ответ_03"));
//    }

    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (questions.remove(question)) {
            return question;
        }
        return null;
    }

    @Override
    public Set<Question> getAll() {
//        return questions;//forTESTS___  getAllCopy()
        return Collections.unmodifiableSet(questions);
    }

    @Override
    public Question getRandomQuestion() {

        if (questions.isEmpty()) {
        throw new NoQuestionsException();
        }

        int index = random.nextInt(questions.size());
        var it = questions.iterator();
        //если вопросов не будет, то nextInt кинет исключение - хорошо бы сделать проверку
        int i = 0;
        while (it.hasNext()) {
            Question q = it.next();
            if (i == index) {
                return q;
            }
         i++;
        }
        return null;// или вернуть null
    }
}

