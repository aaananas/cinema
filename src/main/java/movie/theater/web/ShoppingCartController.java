package movie.theater.web;

import lombok.RequiredArgsConstructor;
import movie.theater.api.BaseResponse;
import movie.theater.service.CinemaGateway;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-carts")
@RequiredArgsConstructor
public class ShoppingCartController {
    private final CinemaGateway cinemaGateway;

    @PostMapping("/movie-sessions")
    public void addToCart(Authentication auth, @RequestParam Long movieSessionId) {
    }

    @GetMapping("/by-user")
    public BaseResponse<Void> getByUser(Authentication auth) {
        return null;
    }
}
