package pro.sky.Examiner.service;

import org.springframework.stereotype.Service;
import pro.sky.Examiner.domain.Question;
import pro.sky.Examiner.exception.QuestionAlreadyAddedException;
import pro.sky.Examiner.exception.QuestionNotFoundForRemoveException;
import pro.sky.Examiner.exception.QuestionStorageIsFullException;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class JavaQuestionService implements QuestionService {
    Set<Question> questions = new HashSet<>();
    private Random random = new Random();

    @Override
    public int  getSize(){
        return questions.size();
    }

    public JavaQuestionService() {
        questions.add(new Question("вопрос_01", "ответ_01"));
        questions.add(new Question("вопрос_02", "ответ_02"));
        questions.add(new Question("вопрос_03", "ответ_03"));
    }

    private final static int MAX_SIZE = 6;//максимальное кол вопросов

    private void validateSize() {
        if (MAX_SIZE == questions.size()) {
            throw new QuestionStorageIsFullException("Массив вопросов переполнен");
        }
    }

    private boolean find(Question question) {
        Set<String> getListQuestion = questions.stream()
                .map(Question::getQuestion)
                .collect(Collectors.toSet());
        return getListQuestion.contains(question.getQuestion());
    }

    @Override
    public Question add(String question, String answer) {
        validateSize();
        Question newQuestion = new Question(question, answer);
        add(newQuestion);
        questions.add(newQuestion);
        return newQuestion;
    }


    private Question add(Question newQuestion) {
        if (find(newQuestion)) {
            throw new QuestionAlreadyAddedException("Добавление невозможно - такой вопрос уже есть");
        }
        return newQuestion;
    }

    @Override
    public Question remove(String question, String answer) {
        Question removeQuestion = new Question(question, answer);
        remove(removeQuestion);
        questions.remove(removeQuestion);
        return removeQuestion;
    }


    public Question remove(Question removeQuestion) {
        if (!find(removeQuestion)) {
            throw new QuestionNotFoundForRemoveException("вопрос не найден - удаление невозможно");
        }
        return removeQuestion;
    }

    @Override
    public Set<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
//        randomIndex(questions.size());
        return List.copyOf(questions).get(random.nextInt(questions.size()));
    }

    private Set<Integer> randomIndex(int size) {
    Set<Integer> generated = new HashSet<Integer>();
    Random r = new Random();
    while (generated.size() < size) {
        generated.add(r.nextInt(9) + 1);
    }
        return generated;
    }
}

