package movie.theater.web;

import java.time.LocalDate;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import movie.theater.api.BaseResponse;
import movie.theater.api.request.MovieSessionRequest;
import movie.theater.model.dto.MovieSessionDto;
import movie.theater.service.CinemaGateway;
import movie.theater.util.DateTimePatternUtil;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie-sessions")
@RequiredArgsConstructor
public class MovieSessionController {
    private static final String DATE_PATTERN = DateTimePatternUtil.DATE_PATTERN;
    private final CinemaGateway cinemaGateway;

    @PostMapping
    public BaseResponse<MovieSessionDto> createMovieSession(@RequestBody @Valid MovieSessionRequest request) {
        MovieSessionDto movieSession = cinemaGateway.createMovieSession(request);
        return BaseResponse.ok(movieSession);
    }

    @GetMapping("/available")
    public BaseResponse<Void> getAll(@RequestParam Long movieId, @RequestParam @DateTimeFormat(pattern = DATE_PATTERN) LocalDate date) {
        // todo
        return null;
    }

    @PutMapping("/{id}")
    public BaseResponse<Void> update(@PathVariable Long id,
                                       @RequestBody @Valid MovieSessionRequest requestDto) {
        //todo
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        //todo
    }
}
