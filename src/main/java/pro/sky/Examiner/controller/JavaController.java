package pro.sky.Examiner.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;
import pro.sky.Examiner.domain.Question;
import pro.sky.Examiner.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaController {
    @ExceptionHandler({HttpStatusCodeException.class})
    public String handlerException(Exception e) {
        return "Code: " + e.getMessage();
    }

    private final QuestionService questionService;

    public JavaController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping()
    public Collection<Question> getQuestions() {
        return questionService.getAll();
    }

    /**добавлен вопрос
     *
     * @param question
     * @param answer
     * @return
     */
    @GetMapping("/add")
    public String addQuestion(@RequestParam String question,
                              @RequestParam String answer) {
        //
        return "Добавлен вопрос и ответ:   " + questionService.add(question, answer);
    }

    @GetMapping("/remove")
    public String removeQuestion(@RequestParam String question,
                                 @RequestParam String answer) {
        return "Удален вопрос и ответ:   " + questionService.remove(question, answer);
    }


}
