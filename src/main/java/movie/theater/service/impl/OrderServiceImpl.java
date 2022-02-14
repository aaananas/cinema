package movie.theater.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import movie.theater.model.Order;
import movie.theater.model.ShoppingCart;
import movie.theater.model.User;
import movie.theater.repository.OrderRepository;
import movie.theater.service.OrderService;
import movie.theater.service.ShoppingCartService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ShoppingCartService shoppingCartService;

    @Override
    public Order completeOrder(ShoppingCart shoppingCart) {
        Order order = new Order();
        order.setOrderTime(LocalDateTime.now());
        order.setTickets(shoppingCart.getTickets());
        order.setUser(shoppingCart.getUser());
        orderRepository.save(order);
        shoppingCartService.clear(shoppingCart);
        return order;
    }

    @Override
    public List<Order> getOrdersHistory(User user) {
        return null;
//        return orderRepository.getOrdersHistory(user);
    }
}
