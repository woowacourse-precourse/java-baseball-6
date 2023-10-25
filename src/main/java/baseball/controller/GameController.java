package baseball.controller;

import baseball.constants.Constants;
import baseball.model.ComputerNumber;
import baseball.model.GameStatusNumber;
import baseball.model.UserNumber;
import baseball.view.StartView;
import baseball.view.EndView;
import baseball.view.MainView;

import java.util.List;

public class GameController {
    private StartView startView = new StartView();
    private UserInputController userInputController = new UserInputController();

    public void startGame() {
        startView.beginMessage();
        playGame();
    }

    public void playGame() {
        ComputerNumber computerNumber = new ComputerNumber();
        GameStatusNumber gameStatusNumber = new GameStatusNumber();
        MainView mainView = new MainView();
        EndView endView = new EndView();


        while (true) {
            UserNumber userNumber = userInputController.getUserInputNumber();
            List<Integer> userNumbers = userNumber.getUserNumber();
            int strike = gameStatusNumber.countStrike(userNumbers, computerNumber.getNumbers());
            int ball = gameStatusNumber.countBall(userNumbers, computerNumber.getNumbers());
            int nothing = gameStatusNumber.countNothing(userNumbers, computerNumber.getNumbers());

            mainView.displayResult(strike, ball, nothing);
            if (strike == Constants.THREE_STRIKE) {
                if (userInputController.getRestartInput()) {
                    computerNumber.resetNumber();
                    userInputController.resetDuplicateNumber();

                } else {
                    break;
                }
            }
        }
    }
}
