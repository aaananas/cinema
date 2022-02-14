package movie.theater.model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import lombok.Data;

@Entity(name = "users")
@Data
public class User extends BaseEntity {
    @Column(unique = true)
    private String email;
    private String name;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;
}
