package movie.theater.service;

import java.util.List;
import movie.theater.api.request.MovieRequest;
import movie.theater.model.dto.MovieDto;

public interface MovieService {
    MovieDto create(MovieRequest request);

    MovieDto get(Long id);

    List<MovieDto> getAll();
}
