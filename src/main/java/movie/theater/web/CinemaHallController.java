package movie.theater.web;

import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import movie.theater.api.BaseResponse;
import movie.theater.api.request.CinemaHallRequest;
import movie.theater.model.dto.CinemaHallDto;
import movie.theater.service.CinemaGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinema-halls")
@RequiredArgsConstructor
public class CinemaHallController {
    private final CinemaGateway cinemaGateway;

    @PostMapping
    public BaseResponse<CinemaHallDto> createCinemaHall(@RequestBody @Valid CinemaHallRequest request) {
        CinemaHallDto hall = cinemaGateway.createCinemaHall(request);
        return BaseResponse.ok(hall);
    }

    @GetMapping
    public BaseResponse<List<CinemaHallDto>> getCinemaHalls() {
        List<CinemaHallDto> cinemaHalls = cinemaGateway.getAllCinemaHalls();
        return BaseResponse.ok(cinemaHalls);
    }

    @GetMapping("/{id}")
    public BaseResponse<CinemaHallDto> getCinemaHall(@PathVariable Long id) {
        CinemaHallDto hall = cinemaGateway.getCinemaHall(id);
        return BaseResponse.ok(hall);
    }
}
