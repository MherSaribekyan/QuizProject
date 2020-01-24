package am.egs.quizproject.endpoint;

import am.egs.quizproject.service.QuizService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testing")
public class QuizEndpoint {
    private final QuizService quizService;

    public QuizEndpoint(QuizService quizService) {
        this.quizService = quizService;
    }


    @GetMapping
    public ResponseEntity getQuizzesForTesting() {
        return ResponseEntity.ok(quizService.getQuizzesForTesting());
    }


}
