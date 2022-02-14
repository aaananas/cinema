package movie.theater.web;

import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import movie.theater.api.BaseResponse;
import movie.theater.api.request.MovieRequest;
import movie.theater.model.dto.MovieDto;
import movie.theater.service.CinemaGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {
    private final CinemaGateway cinemaGateway;

    @PostMapping
    public BaseResponse<MovieDto> createMovie(@RequestBody @Valid MovieRequest request) {
        MovieDto movie = cinemaGateway.createMovie(request);
        return BaseResponse.ok(movie);
    }

    @GetMapping
    public BaseResponse<List<MovieDto>> getAll() {
        List<MovieDto> allMovies = cinemaGateway.getAllMovies();
        return BaseResponse.ok(allMovies);
    }

    @GetMapping("/{id}")
    public BaseResponse<MovieDto> getMovie(@PathVariable Long id) {
        MovieDto movie = cinemaGateway.getMovie(id);
        return BaseResponse.ok(movie);
    }
}
