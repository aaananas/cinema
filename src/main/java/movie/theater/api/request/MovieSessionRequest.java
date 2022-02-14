package movie.theater.api.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MovieSessionRequest {
    @Id
    private Long id;
    @Positive
    private Long movieId;
    @Positive
    private Long cinemaHallId;
    @NotNull
    private String showTime;
}
