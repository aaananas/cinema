package movie.theater.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import lombok.Data;

@Entity(name = "movie_sessions")
@Data
public class MovieSession extends BaseEntity {
    @ManyToOne
    private Movie movie;
    @ManyToOne
    private CinemaHall cinemaHall;
    private LocalDateTime showTime;
}
