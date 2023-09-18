package pro.sky.Examiner.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.Examiner.domain.Question;
import pro.sky.Examiner.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaController {
    private final QuestionService questionService;

    public JavaController(QuestionService questionService) {
        this.questionService = questionService;
    }

    //         /exam/java
    @GetMapping()
    public Collection<Question> getQuestions() {
        return questionService.getAll();
    }

    //         /exam/java/add?question=QuestionText&answer=QuestionAnswer
    @GetMapping("/add")
    public Question addQuestion(@RequestParam String question,
                                @RequestParam String answer) {
        return questionService.add(question, answer);
    }

    //          /exam/java/remove?question=QuestionText&answer=QuestionAnswer
    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam String question,
                                   @RequestParam String answer) {
        return questionService.remove(new Question(question, answer));
    }
}
