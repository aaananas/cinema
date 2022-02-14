package movie.theater.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Data;

@Entity(name = "shopping_carts")
@Data
public class ShoppingCart extends BaseEntity {
    @OneToMany
    private List<Ticket> tickets;
    @MapsId
    @OneToOne
    private User user;
}
