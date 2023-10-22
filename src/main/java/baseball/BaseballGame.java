package baseball;

import baseball.logic.GameManage;
import baseball.logic.InputValidator;
import java.util.List;

public class BaseballGame {
    private final Computer computer = new Computer();

    private final User user = new User();

    private final InputValidator validator = new InputValidator();

    private final GameManage gameManage = new GameManage();

    private final GameMessage gameMessage = new GameMessage();


    public BaseballGame() {
        gameMessage.initGame();
    }

    public void start() {
        int command = 1;
        List<Integer> answerNumbers = computer.makeNumbers();

        while (command == 1) {
            gameManage.init();
            gameMessage.getInputNumber();
            String userInput = user.inputNumbers();
            List<Integer> userNumbers = validator.validateInput(userInput);

            gameManage.getResult(answerNumbers, userNumbers);
            gameManage.showResult();
            if (gameManage.getStrikeCount() == 3) {
                gameMessage.endGame();
                gameMessage.getInputCommand();
                command = user.commandInput();

                if (command == 1) {
                    answerNumbers = computer.makeNumbers();
                }
            }
        }
    }
}
