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
        GameStatus gameStatus;
        AppConfig appConfig = new AppConfig();
        GameSetting gameSetting = appConfig.gameSetting();

        gameSetting.startGame();
        gameStatus = GameStatus.PROGRESS;
        while (true) {
            gameSetting.progressGame();
            gameStatus = gameSetting.questionRestartGame(gameStatus);
            if(gameStatus == GameStatus.STOP){
                break;
            }
        }

    }
}
