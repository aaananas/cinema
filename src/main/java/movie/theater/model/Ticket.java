package movie.theater.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import lombok.Data;

@Entity(name = "tickets")
@Data
public class Ticket extends BaseEntity {
    @ManyToOne
    private MovieSession movieSession;
    @ManyToOne
    private User user;
}
