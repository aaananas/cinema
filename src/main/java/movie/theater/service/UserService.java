package movie.theater.service;

import movie.theater.model.User;
import movie.theater.model.dto.UserDto;

public interface UserService {
    UserDto save(User user);

    UserDto get(Long id);

    UserDto findByEmail(String email);
}
