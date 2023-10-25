package baseball.domain;

import baseball.logic.GameManage;
import baseball.logic.InputValidator;

import java.util.List;

import static baseball.constant.Constant.*;

public class BaseballGame {
    private final Computer computer;

    private final User user;

    private final InputValidator validator;

    private final GameManage gameManage;

    private final GameMessage gameMessage;

    private List<Integer> answerNumbers;


    public BaseballGame() {
        computer = new Computer();
        user = new User();
        validator = new InputValidator();
        gameManage = new GameManage();
        gameMessage = new GameMessage();
    }

    public void start() {
        int command = COMMAND_RESTART;
        answerNumbers = computer.makeNumbers();

        gameMessage.initGame();

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
