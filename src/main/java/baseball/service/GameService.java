package baseball.service;

import baseball.domain.GameRestartOption;
import baseball.domain.GameSet;

public class GameService {
    private GameService() {}

    public static GameSet startGameSet() {
        return new GameSet();
    }

    public static boolean isRestart(String restartOption) {
        GameRestartOption gameRestartOption = GameRestartOption.from(restartOption);
        return gameRestartOption.isRestart();
    }
}
