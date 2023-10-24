package baseball.Controller;

import baseball.Model.BaseBallGame;
import baseball.Model.GameState;
import baseball.Model.Helper;
import baseball.Model.Valid;
import baseball.View.GameView;
import java.util.List;

public class GameController {
    private GameView gameView = new GameView();
    private GameState gameState;

    public void startGame() {
        Helper helper = new Helper();
        gameState = GameState.GAME_START;

        gameView.printStartMessage();

        while (gameState != GameState.GAME_END) {
            BaseBallGame baseBallGame = new BaseBallGame(helper);
            playGame(helper, baseBallGame);
            String inputRestart = gameView.printGameOverMessage();
            gameState = GameState.gameRestart(Valid.restartValid(inputRestart));
        }
    }

    public void playGame(Helper helper, BaseBallGame baseBallGame) {
        while (gameState != GameState.GAME_OVER) {
            String input = Valid.startValid(gameView.printInputMessage());
            List<Integer> userInput = helper.parseUserInput(input);
            List<Integer> ballStrikeCount = baseBallGame.checkBallCount(userInput);

            gameView.printBallStrikeMessage(ballStrikeCount);
            gameState = GameState.gameOver(baseBallGame.checkThreeStrike(ballStrikeCount));
        }
    }

}