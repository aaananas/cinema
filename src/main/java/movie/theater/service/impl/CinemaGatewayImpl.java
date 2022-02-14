package movie.theater.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import movie.theater.api.request.CinemaHallRequest;
import movie.theater.api.request.MovieRequest;
import movie.theater.api.request.MovieSessionRequest;
import movie.theater.model.dto.CinemaHallDto;
import movie.theater.model.dto.MovieDto;
import movie.theater.model.dto.MovieSessionDto;
import movie.theater.service.CinemaGateway;
import movie.theater.service.CinemaHallService;
import movie.theater.service.MovieService;
import movie.theater.service.MovieSessionService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CinemaGatewayImpl implements CinemaGateway {
    private final MovieService movieService;
    private final CinemaHallService hallService;
    private final MovieSessionService sessionService;

    @Override
    public MovieDto createMovie(MovieRequest request) {
        return movieService.create(request);
    }

    @Override
    public List<MovieDto> getAllMovies() {
        return movieService.getAll();
    }

    @Override
    public MovieDto getMovie(Long id) {
        return movieService.get(id);
    }

    @Override
    public CinemaHallDto createCinemaHall(CinemaHallRequest request) {
        return hallService.create(request);
    }

    @Override
    public List<CinemaHallDto> getAllCinemaHalls() {
        return hallService.getAll();
    }

    @Override
    public CinemaHallDto getCinemaHall(Long id) {
        return hallService.get(id);
    }

    @Override
    public MovieSessionDto createMovieSession(MovieSessionRequest request) {
        return sessionService.create(request);
    }
}
