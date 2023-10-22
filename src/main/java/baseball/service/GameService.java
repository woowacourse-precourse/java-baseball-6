package baseball.service;

import baseball.domain.GameSet;

public class GameService {
    private GameService() {}

    public static GameSet startGameSet() {
        return new GameSet();
    }
}
