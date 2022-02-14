package movie.theater.api.request;

import java.util.Set;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import movie.theater.lib.FieldsValueMatch;
import movie.theater.lib.ValidEmail;

@FieldsValueMatch(
        field = "password",
        fieldMatch = "repeatPassword",
        message = "Passwords do not match!"
)
@Data
@NoArgsConstructor
public class UserRequest {
    @ValidEmail
    private String email;
    private String name;
    @Size(min = 8, max = 40)
    private String password;
    private String repeatPassword;
    private Set<String> roles;
}
