package baseball.repository;

import baseball.domain.Game;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MemoryGameRepository implements GameRepository{
    private static Map<Long, Game> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Game save(Game game) {
        return null;
    }

    @Override
    public Optional<Game> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Game> findByUserId(Long userId) {
        return Optional.empty();
    }

    @Override
    public List<Game> findAll() {
        return null;
    }
}
