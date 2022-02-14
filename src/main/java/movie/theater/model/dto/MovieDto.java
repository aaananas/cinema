package movie.theater.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MovieDto {
    private Long id;
    private String title;
    private String description;
}
