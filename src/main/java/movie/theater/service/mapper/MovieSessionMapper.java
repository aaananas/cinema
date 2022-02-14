package movie.theater.service.mapper;

import lombok.RequiredArgsConstructor;
import movie.theater.api.request.MovieSessionRequest;
import movie.theater.model.CinemaHall;
import movie.theater.model.Movie;
import movie.theater.model.MovieSession;
import movie.theater.repository.CinemaHallRepository;
import movie.theater.repository.MovieRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
@RequiredArgsConstructor
public abstract class MovieSessionMapper {
    private final MovieRepository movieRepository;
    private final CinemaHallRepository hallRepository;

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "movie", expression = "java(getMovieById(source.getMovieId()))"),
            @Mapping(target = "cinemaHall", expression = "java(getCinemaHallById(source.getCinemaHallId()))")
    })
    public abstract void mapUpdateRequest(@MappingTarget MovieSession session, MovieSessionRequest source);

    protected Movie getMovieById(Long movieId) {
        return movieRepository.getById(movieId);
    }

    protected CinemaHall getCinemaHallById(Long hallId) {
        return hallRepository.getById(hallId);
    }
}
