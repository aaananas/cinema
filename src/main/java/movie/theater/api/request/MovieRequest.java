package movie.theater.api.request;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MovieRequest {
    @Id
    private Long id;
    @NotNull
    private String title;
    @Size(max = 200)
    private String description;
}
