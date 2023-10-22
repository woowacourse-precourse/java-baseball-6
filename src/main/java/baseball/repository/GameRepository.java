package baseball.repository;

import baseball.domain.Game;

import java.util.List;
import java.util.Optional;

public interface GameRepository {
    Game save(Game game);
    Optional<Game> findById(Long id);
    Optional<Game> findByUserId(Long userId);
    List<Game> findAll();
}
