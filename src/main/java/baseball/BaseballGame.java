package baseball;

import static baseball.BaseballConstants.END_CHOICE;
import static baseball.BaseballConstants.STRIKE_MESSAGE;

public class BaseballGame {
    private final User user;
    private final Computer computer;
    private final InputValueValidator validator;
    private final GameController gameController;
    private final GameSupervisor supervisor;

    public BaseballGame(User user, Computer computer, InputValueValidator validator, GameController gameController, GameSupervisor supervisor) {
        this.user = user;
        this.computer = computer;
        this.validator = validator;
        this.gameController = gameController;
        this.supervisor = supervisor;
    }

    public void gameStart() {
        GameMessagesPrinter.startGameMessage();
        playGameLoop();
    }


    private void playGameLoop() {
        while (true) {
            String userNumber = user.inputNumber();
            computer.pickRandomNum();
            validator.validateInputValue(userNumber);
            String result = gameController.evaluateUserNum(userNumber);
            supervisor.resetGameStatus();
            System.out.println(result);

            if (checkResult(result)) {
                break;
            }
        }
    }

    private boolean checkResult(String result) {
        if (result.equals(STRIKE_MESSAGE)) {
            GameMessagesPrinter.successMessage();
            GameMessagesPrinter.restartMessage();
            return askUserChoice();
        }
        return false;
    }

    private boolean askUserChoice() {
        if (END_CHOICE.equals(user.choice())) {
            GameMessagesPrinter.endGameMessage();
            return true;
        } else {
            computer.reset();
            computer.pickRandomNum();
            return false;
        }
    }
}

