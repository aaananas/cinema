package movie.theater.model.dto;

import lombok.Data;

@Data
public class CinemaHallDto {
    private Long id;
    private int capacity;
    private String description;
}
