package movie.theater.service.impl;

import lombok.RequiredArgsConstructor;
import movie.theater.api.request.UserRequest;
import movie.theater.model.dto.UserDto;
import movie.theater.service.AuthenticationService;
import movie.theater.service.UserGateway;
import movie.theater.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserGatewayImpl implements UserGateway {
    private final AuthenticationService authenticationService;
    private final UserService userService;
    private final ModelMapper modelMapper;

    @Override
    public UserDto create(UserRequest request) {
        return authenticationService.register(request);
    }

    @Override
    public UserDto getByEmail(String email) {
        return userService.findByEmail(email);
    }
}
