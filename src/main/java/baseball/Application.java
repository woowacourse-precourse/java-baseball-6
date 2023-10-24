package baseball;

import baseball.game.gamesetter.GameSetting;

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