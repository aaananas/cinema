package movie.theater.service.impl;

import java.util.Set;
import lombok.RequiredArgsConstructor;
import movie.theater.api.request.UserRequest;
import movie.theater.model.Role;
import movie.theater.model.User;
import movie.theater.model.dto.UserDto;
import movie.theater.service.AuthenticationService;
import movie.theater.service.RoleService;
import movie.theater.service.ShoppingCartService;
import movie.theater.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;
    private final RoleService roleService;
    private final PasswordEncoder encoder;
    private final ModelMapper modelMapper;

    @Override
    public UserDto register(UserRequest userRequest) {
        User user = new User();
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(encoder.encode(userRequest.getPassword()));
        user.setRoles(Set.of(roleService.getRoleByName(Role.RoleName.USER)));
        userService.save(user);
        shoppingCartService.registerNewShoppingCart(user);
        return modelMapper.map(user, UserDto.class);
    }
}
