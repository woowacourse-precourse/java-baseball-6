package baseball;

import baseball.Controller.Game;
import baseball.View.InputView;
import baseball.View.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();


        boolean restartGame = true;
        while (restartGame) {
            Game game = new Game(inputView, outputView);
            game.play();
            outputView.showGameOver();
            restartGame = checkRestart(inputView);
        }
    }

    private static boolean checkRestart(InputView inputView) {
        return inputView.restartGame();
    }
}
