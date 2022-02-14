package movie.theater.model;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Data;

@Entity(name = "orders")
@Data
public class Order extends BaseEntity {
    @OneToMany
    private List<Ticket> tickets;
    private LocalDateTime orderTime;
    @ManyToOne
    private User user;
}
