package am.egs.quizproject.repository;

import am.egs.quizproject.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {

    public List<Answer> getAllById(long id);

}
