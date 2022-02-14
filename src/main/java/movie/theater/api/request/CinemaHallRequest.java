package movie.theater.api.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CinemaHallRequest {
    @Min(10)
    private int capacity;
    @Size(max = 200)
    private String description;
}
