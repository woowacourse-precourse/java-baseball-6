package baseball.repository;

import baseball.domain.Game;

import java.util.Optional;
import java.util.stream.Stream;

public interface GameRepository {
    Game save(Game game);
    Game saveQestionCount(Game game);
    Optional<Game> findById(Long id);
    Stream<Game> findByUserId(Long userId);
}
