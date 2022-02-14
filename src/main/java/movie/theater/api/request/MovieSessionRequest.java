package movie.theater.api.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MovieSessionRequest {
    @Positive
    private Long movieId;
    @Positive
    private Long cinemaHallId;
    @NotNull
    private String showTime;
}
