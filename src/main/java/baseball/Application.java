package baseball;

import static baseball.util.Constants.RESTART_INPUT;
import static baseball.view.OutPutView.displayRestartOrExitMessage;

import baseball.controller.GameController;
import baseball.domain.ComputerNumbers;
import baseball.domain.Referee;
import baseball.util.InputValidation;
import baseball.view.InputView;
import baseball.view.OutPutView;

public class Application {
    public static void main(String[] args) {
        OutPutView.displayGameStartMessage();
        do {
            ComputerNumbers computer = new ComputerNumbers();
            Referee referee = new Referee();
            GameController gameController = new GameController(computer, referee);
            gameController.gameStart();
            displayRestartOrExitMessage();
        } while (isRestart());
    }

    public static boolean isRestart() {
        String number = inputNumber();
        return number.equals(RESTART_INPUT);
    }

    public static String inputNumber() {
        String restartNumber = InputView.inputNumber();
        InputValidation.validateRestartOrExitInput(restartNumber);
        return restartNumber;
    }

}
