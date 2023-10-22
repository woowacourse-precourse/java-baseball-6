package baseball;

import baseball.logic.GameManage;
import baseball.logic.InputValidator;
import java.util.List;

import static baseball.constant.Constant.*;

public class BaseballGame {
    private final Computer computer = new Computer();

    private final User user = new User();

    private final InputValidator validator = new InputValidator();

    private final GameManage gameManage = new GameManage();

    private final GameMessage gameMessage = new GameMessage();

    private List<Integer> answerNumbers;


    public BaseballGame() {
        gameMessage.initGame();
    }

    public void start() {
        int command = COMMAND_RESTART;
        answerNumbers = computer.makeNumbers();

        while (command == COMMAND_RESTART) {
            gameManage.init();
            gameMessage.getInputNumber();
            String userInput = user.inputNumbers();
            List<Integer> userNumbers = validator.validateInput(userInput);

            gameManage.getResult(answerNumbers, userNumbers);

            int strike = gameManage.getStrikeCount();
            int ball = gameManage.getBallCount();
            gameMessage.showResult(strike, ball);

            command = checkEndGame(strike);
        }
    }

    private int checkEndGame(int strike) {
        int command = COMMAND_RESTART;

        if (strike == ALL_STRIKE) {
            gameMessage.endGame();
            gameMessage.getInputCommand();
            command = user.commandInput();
            checkCommandRestart(command);
        }

        return command;
    }

    private void checkCommandRestart(int command) {
        if (command == COMMAND_RESTART) {
            answerNumbers = computer.makeNumbers();
        }
    }
}
