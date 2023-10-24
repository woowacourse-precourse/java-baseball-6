package baseball.repository;

import baseball.domain.Game;

import java.util.*;
import java.util.stream.Stream;

public class MemoryGameRepository implements GameRepository{
    private static Map<Long, Game> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Game save(Game game) {
        game.setId(++sequence);
        store.put(game.getId(), game);
        return game;
    }

    @Override
    public Game saveQestionCount(Game game) {
        Long l = game.getQuestionCount();
        store.get(game.getId()).setQuestionCount(++l);
        return game;
    }

    @Override
    public Optional<Game> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Stream<Game> findByUserId(Long userId) {
        return store.values().stream()
                .filter(game -> game.getUserId().equals(userId));
    }

    public void clearStore(){
        store.clear();
    }
}
