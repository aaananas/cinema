package movie.theater.service;

import java.time.LocalDate;
import java.util.List;
import movie.theater.api.request.MovieSessionRequest;
import movie.theater.model.MovieSession;
import movie.theater.model.dto.MovieSessionDto;

public interface MovieSessionService {

    List<MovieSession> findAvailableSessions(Long movieId, LocalDate date);

    MovieSessionDto get(Long id);

    MovieSessionDto update(MovieSessionRequest request);

    MovieSessionDto create(MovieSessionRequest request);

    List<MovieSessionDto> getAll();

    void delete(Long id);

    List<MovieSessionDto> getAllByMovieIdAndDate(Long movieId, LocalDate date);
}
