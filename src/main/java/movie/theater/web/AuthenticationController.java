package movie.theater.web;

import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import movie.theater.api.BaseResponse;
import movie.theater.api.request.UserRequest;
import movie.theater.model.dto.UserDto;
import movie.theater.service.UserGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {
    private final UserGateway userGateway;

    @PostMapping("/register")
    public BaseResponse<UserDto> register(@RequestBody @Valid UserRequest request) {
        UserDto userDto = userGateway.create(request);
        return BaseResponse.ok(userDto);
    }
}
