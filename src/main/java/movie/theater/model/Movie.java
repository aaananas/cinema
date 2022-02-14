package movie.theater.model;

import javax.persistence.Entity;
import lombok.Data;

@Entity(name = "movies")
@Data
public class Movie extends BaseEntity {
    private String title;
    private String description;
}
