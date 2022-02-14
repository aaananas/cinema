package movie.theater.service;

import java.util.List;
import movie.theater.api.request.CinemaHallRequest;
import movie.theater.model.dto.CinemaHallDto;

public interface CinemaHallService {
    CinemaHallDto create(CinemaHallRequest request);

    CinemaHallDto get(Long id);

    List<CinemaHallDto> getAll();
}
