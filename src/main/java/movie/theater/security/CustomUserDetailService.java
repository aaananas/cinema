package movie.theater.security;

import lombok.RequiredArgsConstructor;
import movie.theater.model.User;
import movie.theater.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static org.springframework.security.core.userdetails.User.withUsername;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) {
        User user = userRepository.findUserByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        org.springframework.security.core.userdetails.User.UserBuilder userBuilder =
                withUsername(email).password(user.getPassword())
                .roles(user.getRoles().stream()
                        .map(r -> r.getName().toString()).toArray(String[]::new));
        return userBuilder.build();
    }
}
