package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameMaster<T extends Game> {
    private final Game game;

    public GameMaster(T game) {
        this.game = game;
    }
}
