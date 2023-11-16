package baseball.game.repository;

import baseball.game.entity.Computer;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ComputerRepository {
    private static long id = 0L;
    private static Map<Long, Computer> store = new HashMap<>();
    private static ComputerRepository instance;

    private ComputerRepository() {
    }

    public static ComputerRepository getInstance() {
        if (instance == null) {
            return instance = new ComputerRepository();
        }
        return instance;
    }

    public Computer save(Computer game) {
        store.put(game.getId(), game);
        return game;
    }

    public Optional<Computer> findBy(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    public void update(Computer computer) {
        store.put(computer.getId(), computer);
    }
}
