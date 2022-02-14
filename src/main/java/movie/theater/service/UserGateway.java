package movie.theater.service;

import movie.theater.api.request.UserRequest;
import movie.theater.model.dto.UserDto;

public interface UserGateway {
    UserDto create(UserRequest request);

    UserDto getByEmail(String email);
}
