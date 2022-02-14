package movie.theater.service;

import movie.theater.api.request.UserRequest;
import movie.theater.model.dto.UserDto;

public interface AuthenticationService {
    UserDto register(UserRequest request);
}
