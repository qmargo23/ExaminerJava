package pro.sky.Examiner.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import pro.sky.Examiner.domain.Question;
import pro.sky.Examiner.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaController {

    private final QuestionService service;

    public JavaController(@Qualifier("javaQuestionService") QuestionService service) {
        this.service = service;
    }

//  localhost:8080/exam/java/add?question=question_00&answer=answer_00
    @GetMapping("/add")
    Question addQuestion(@RequestParam String question, @RequestParam String answer) {
        return service.add(question, answer);
    }
//  localhost:8080/exam/java/remove?question=question_00&answer=answer_00
    @GetMapping("/remove")
    Question removeQuestion(@RequestParam String question, @RequestParam String answer) {
        return service.remove(new Question(question, answer));
    }
//  localhost:8080/exam/java
    @GetMapping
    Collection<Question> getQuestions() {
        return service.getAll();
    }
}
