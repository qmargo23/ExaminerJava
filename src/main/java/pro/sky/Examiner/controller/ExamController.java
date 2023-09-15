package pro.sky.Examiner.controller;

import org.springframework.web.bind.annotation.*;
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

    //              /exam/get?amount=3
    @GetMapping("/get/{amount:\\d+}")
    Collection<Question> getQuestions(@PathVariable int amount) {
        return examinerService.getQuestions(amount);
    }
}
