package movie.theater.web;

import lombok.RequiredArgsConstructor;
import movie.theater.api.BaseResponse;
import movie.theater.model.dto.UserDto;
import movie.theater.service.UserGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserGateway userGateway;

    @GetMapping("/by-email")
    public BaseResponse<UserDto> getByEmail(@RequestParam String email) {
        UserDto userDto = userGateway.getByEmail(email);
        return BaseResponse.ok(userDto);
    }
}
