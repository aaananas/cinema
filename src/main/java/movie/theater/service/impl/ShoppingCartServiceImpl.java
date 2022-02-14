package movie.theater.service.impl;

import lombok.RequiredArgsConstructor;
import movie.theater.model.MovieSession;
import movie.theater.model.ShoppingCart;
import movie.theater.model.Ticket;
import movie.theater.model.User;
import movie.theater.repository.ShoppingCartRepository;
import movie.theater.repository.TicketRepository;
import movie.theater.service.ShoppingCartService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartRepository shoppingCartDao;
    private final TicketRepository ticketDao;

    @Override
    public void addSession(MovieSession movieSession, User user) {
        Ticket ticket = new Ticket();
//        ticket.setMovieSession(movieSession);
//        ticket.setUser(user);
//        ShoppingCart shoppingCart = shoppingCartDao.getByUser(user);
//        ticketDao.add(ticket);
//        shoppingCart.getTickets().add(ticket);
//        shoppingCartDao.update(shoppingCart);
    }

    @Override
    public ShoppingCart getByUser(User user) {
        return null;
//        return shoppingCartDao.getByUser(user);
    }

    @Override
    public void registerNewShoppingCart(User user) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUser(user);
//        shoppingCartDao.add(shoppingCart);
    }

    @Override
    public void clear(ShoppingCart shoppingCart) {
//        shoppingCart.setTickets(null);
//        shoppingCartDao.update(shoppingCart);
    }
}
