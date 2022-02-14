package movie.theater.repository;

import java.time.LocalDate;
import java.util.List;
import movie.theater.model.MovieSession;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MovieSessionRepository extends JpaRepository<MovieSession, Long> {
    @Modifying
    @Query(value = "UPDATE movie_sessions SET status = 1 WHERE id = :id")
    void archive(Long id);

    List<MovieSession> findAllByStatus(int status);

    @Query(nativeQuery = true, value = "SELECT * FROM movie_sessions WHERE movie_id = :movieId AND show_time = :date")
    List<MovieSession> findAllByMovieIdAndDate(Long movieId, LocalDate date);
}
