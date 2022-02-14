package movie.theater.service.impl;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import movie.theater.api.request.MovieSessionRequest;
import movie.theater.exception.DataProcessingException;
import movie.theater.model.MovieSession;
import movie.theater.model.dto.MovieSessionDto;
import movie.theater.repository.MovieSessionRepository;
import movie.theater.service.MovieSessionService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieSessionServiceImpl implements MovieSessionService {
    private final MovieSessionRepository movieSessionRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDate date) {
        // todo
        return Collections.emptyList();
    }

    @Override
    public MovieSessionDto get(Long id) {
        return modelMapper.map(getFromDb(id), MovieSessionDto.class);
    }

    @Override
    public MovieSessionDto update(MovieSessionDto dto) {
        // todo
        return null;
    }

    private MovieSession getFromDb(Long id) {
        return movieSessionRepository.findById(id).orElseThrow(
                () -> new DataProcessingException("Session with id " + id + " not found"));
    }

    @Override
    public MovieSessionDto create(MovieSessionRequest request) {
        MovieSession session = modelMapper.map(request, MovieSession.class);
        return modelMapper.map(movieSessionRepository.save(session), MovieSessionDto.class);
    }

    @Override
    public List<MovieSessionDto> getAll() {
        return movieSessionRepository.findAllByStatus(0).stream()
                .map(e -> modelMapper.map(e, MovieSessionDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        archive(id);
    }

    private void archive(Long id) {
        movieSessionRepository.archive(id);
    }
}
