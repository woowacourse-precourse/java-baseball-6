package baseball.service;

import baseball.domain.GameRestartOption;
import baseball.domain.GameSet;
import baseball.domain.RandomGameNumbersGenerator;
import baseball.domain.gamenumber.GameNumbers;

public class GameService {
    private GameService() {}

    public static GameSetService startGameSet() {
        GameNumbers computerGameNumbers = RandomGameNumbersGenerator.generateRandomGameNumbers();
        GameSet gameSet = new GameSet(computerGameNumbers);

        return new GameSetService(gameSet);
    }

    public static boolean isRestart(String restartOption) {
        GameRestartOption gameRestartOption = GameRestartOption.from(restartOption);
        return gameRestartOption.isRestart();
    }
}
