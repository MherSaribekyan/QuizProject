package am.egs.quizproject.service;

import am.egs.quizproject.exception.UserNotFoundException;
import am.egs.quizproject.model.User;
import am.egs.quizproject.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean isExists(String email) {
        return userRepository.getByEmail(email).isPresent();
    }

    public boolean isExists(int id) {
        return userRepository.findById(id).isPresent();
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    public User findById(int id) throws UserNotFoundException {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    public User findByEmail(String email) throws UserNotFoundException {
        return userRepository.getByEmail(email).orElseThrow(UserNotFoundException::new);
    }
}
