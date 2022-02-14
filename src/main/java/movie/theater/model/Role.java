package movie.theater.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.Data;

@Entity(name = "roles")
@Data
public class Role extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private RoleName name;

    public enum RoleName {
        ADMIN,
        USER
    }
}
