package am.egs.quizproject.security;

import am.egs.quizproject.model.User;
import am.egs.quizproject.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CurrentUserDetailServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public CurrentUserDetailServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.getByEmail(s).get();
        if (user == null){
            throw new UsernameNotFoundException("Username nor found");
        }
        return new CurrentUser(user);
    }
}
