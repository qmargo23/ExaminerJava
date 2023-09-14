package pro.sky.Examiner.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;
import pro.sky.Examiner.domain.Question;
import pro.sky.Examiner.service.ExaminerService;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }


    //localhost:8080/exam/get/
    @GetMapping("/get/{amount}")
    public Collection<Question> getQuestion(@PathVariable Integer amount) {
        return examinerService.getQuestions(amount);
    }

    @ExceptionHandler({HttpStatusCodeException.class})
    public String handlerException(Exception e) {
        return "Code: " + e.getMessage();
    }
}
