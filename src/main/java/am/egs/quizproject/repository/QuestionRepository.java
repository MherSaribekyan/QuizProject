package am.egs.quizproject.repository;

import am.egs.quizproject.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question,Integer> {


}
