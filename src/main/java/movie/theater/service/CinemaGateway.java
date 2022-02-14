package movie.theater.service;

import java.util.List;
import movie.theater.api.request.CinemaHallRequest;
import movie.theater.api.request.MovieRequest;
import movie.theater.api.request.MovieSessionRequest;
import movie.theater.model.dto.CinemaHallDto;
import movie.theater.model.dto.MovieDto;
import movie.theater.model.dto.MovieSessionDto;

public interface CinemaGateway {
    MovieDto createMovie(MovieRequest request);

    List<MovieDto> getAllMovies();

    MovieDto getMovie(Long id);

    CinemaHallDto createCinemaHall(CinemaHallRequest request);

    List<CinemaHallDto> getAllCinemaHalls();

    CinemaHallDto getCinemaHall(Long id);

    MovieSessionDto createMovieSession(MovieSessionRequest request);
}
