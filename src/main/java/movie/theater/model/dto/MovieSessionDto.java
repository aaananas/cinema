package movie.theater.model.dto;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;
import movie.theater.model.CinemaHall;
import movie.theater.model.Movie;

@Data
@NoArgsConstructor
public class MovieSessionDto {
    private Long id;
    private Movie movie;
    private CinemaHall cinemaHall;
    private LocalDateTime showTime;
}
