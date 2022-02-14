package movie.theater.web;

import lombok.RequiredArgsConstructor;
import movie.theater.api.BaseResponse;
import movie.theater.service.OrderService;
import movie.theater.service.ShoppingCartService;
import movie.theater.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final ShoppingCartService shoppingCartService;
    private final OrderService orderService;
    private final UserService userService;

    @PostMapping("/complete")
    public BaseResponse<Void> completeOrder(Authentication auth) {
        return null;
    }

    @GetMapping
    public BaseResponse<Void> getOrderHistory(Authentication auth) {
        return null;
    }
}
