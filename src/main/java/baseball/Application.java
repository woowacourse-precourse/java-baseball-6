package baseball;

import baseball.game.CheckingBoard;
import baseball.game.Score;
import baseball.game.gamesetter.GameSetting;
import baseball.game.hitter.Hitter;
import baseball.game.hitter.PlayerHitterImpl;
import baseball.game.pitcher.ComputerRandomPitcherImpl;
import baseball.game.pitcher.Pitcher;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        GameSetting gameSetting = appConfig.gameSetting();

        gameSetting.startGame();
        gameSetting.progressGame();

    }
}
