package baseball;

import java.util.List;

public class GameController {
    private GameModel gameModel;
    private final GameView gameView;

    public GameController() {
        gameView = new GameView();
    }

    public void start() {
        gameView.displayMessage("숫자 야구 게임을 시작합니다.");
        String continueFlag;
        do {
            gameModel = new GameModel();
            playGame();
            continueFlag = gameView.askReplayOrExit();
        } while (continueFlag.equals("1"));
    }

    private void playGame() {
        String gameResult;
        do {
            List<String> playerNum = gameView.getPlayerInput();
            gameModel.verifyPlayerNum(playerNum);
            gameResult = gameModel.matchPlayerNum(playerNum);
            gameView.displayMessage(gameResult);
        } while (!gameResult.equals("3스트라이크"));
    }
}

