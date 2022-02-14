package movie.theater.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import movie.theater.api.request.MovieRequest;
import movie.theater.exception.DataProcessingException;
import movie.theater.model.Movie;
import movie.theater.model.dto.MovieDto;
import movie.theater.repository.MovieRepository;
import movie.theater.service.MovieService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;
    private final ModelMapper modelMapper;

    @Override
    public MovieDto create(MovieRequest request) {
        Movie movie = modelMapper.map(request, Movie.class);
        Movie saved = movieRepository.save(movie);
        return modelMapper.map(saved, MovieDto.class);
    }

    @Override
    public MovieDto get(Long id) {
        Movie movie = getMovie(id);
        return modelMapper.map(movie, MovieDto.class);
    }

    private Movie getMovie(Long id) {
        return movieRepository.findById(id).orElseThrow(
                () -> new DataProcessingException("Can't get movie by id " + id));
    }

    @Override
    public List<MovieDto> getAll() {
        return movieRepository.findAll().stream()
                .map(e -> modelMapper.map(e, MovieDto.class))
                .collect(Collectors.toList());
    }
}
