package movie.theater.model;

import javax.persistence.Entity;
import lombok.Data;

@Entity(name = "cinema_halls")
@Data
public class CinemaHall extends BaseEntity {
    private int capacity;
    private String description;
}
