package movie.theater.repository;

import java.util.List;
import movie.theater.model.MovieSession;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MovieSessionRepository extends JpaRepository<MovieSession, Long> {
    @Modifying
    @Query(value = "UPDATE movie_sessions SET status = 1 where id = :id")
    void archive(Long id);

    List<MovieSession> findAllByStatus(int status);
}
