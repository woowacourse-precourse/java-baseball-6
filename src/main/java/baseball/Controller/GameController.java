package baseball.Controller;

import baseball.Model.GameModel;
import baseball.View.InputView;
import baseball.View.OutputView;

public class GameController {
    private GameModel model;
    private InputView inputView;
    private OutputView outputView;

    public GameController() {
        model = new GameModel();
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void startGame() {
        outputView.displayGameStart();

        while (true) {
            int[] userNumbers = inputView.setUserInput();
            int strikes = model.calculateStrikes(userNumbers);
            int balls = model.calculateBalls(userNumbers);
            outputView.displayResult(strikes, balls);

            if (model.isGameWon(userNumbers)) {

                outputView.displayGameWon();

                if (!askForReGame()) {
                    break;
                }
                model.resetGame();
            }
        }
    }


    private boolean askForReGame() {
        String choice = inputView.setReGameNum();
        if (!choice.equals("1") && !choice.equals("2")) {
            throw new IllegalArgumentException();
        }
        if(choice.equals("2"))return false;
        return choice.equals("1");
    }
}
