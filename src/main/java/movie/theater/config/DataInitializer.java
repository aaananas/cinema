package movie.theater.config;

import java.util.Set;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import movie.theater.api.request.UserRequest;
import movie.theater.model.Role;
import movie.theater.model.User;
import movie.theater.service.AuthenticationService;
import movie.theater.service.RoleService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer {
    private final RoleService roleService;
    private final AuthenticationService authService;

    @PostConstruct
    public void init() {
        Role adminRole = new Role();
        adminRole.setName(Role.RoleName.ADMIN);
        roleService.add(adminRole);
        User admin = new User();
        UserRequest request = new UserRequest();
        request.setEmail("admin@theater.ua");
        request.setPassword("admin111");
        request.setRepeatPassword("admin111");
        request.setRoles(Set.of("ADMIN"));
        authService.register(request);

    }
}
