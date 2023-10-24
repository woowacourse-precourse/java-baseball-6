package baseball.Controller;

import baseball.Model.Computer;
import baseball.Model.User;
import baseball.Utils.Checker;
import baseball.Utils.InputSystem;
import baseball.View.InputView;
import baseball.View.OutputView;


public class ControllerSystem {
    private User user;
    private Computer computer;
    private Checker checker;

    public ControllerSystem() {
        user = new User();
        computer = new Computer();
        checker = new Checker();
    }

    public void gameStart() {
        var computerNumbers = computer.getComputerNumber();

        do {
            gamePlay(computerNumbers);
        } while (isGameSet() == false);

        OutputView.printGameOverMessage();
        askRetryGame();
    }

    private void gamePlay(int[] computerNumbers) {
        InputView.printSetUserNumberMessage();
        var userNumbers = user.getUserNumbers();
        checker.checkScore(computerNumbers, userNumbers);
    }

    private void askRetryGame() {
        InputView.printSetRetryMessage();
        if (InputSystem.inputRetryAnswer() == true) {
            gameStart();
        }
    }

    private boolean isGameSet() {
        if (checker.isThreeStrike()) {
            return true;
        }

        return false;
    }


}
