package baseball.repository;

import baseball.domain.Game;
import baseball.domain.GameState;

public class GameRepo {

    private static Game game;

    public static void save(Game game) {
        GameRepo.game = game;
    }

    public static Game find() {
        return GameRepo.game;
    }
}
