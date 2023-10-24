package baseball;

import static baseball.constants.GameConstants.COUNT;
import static baseball.constants.GameConstants.ENDGAME_MSG;
import static baseball.constants.GameConstants.END_INCLUSIVE;
import static baseball.constants.GameConstants.INPUT_MSG;
import static baseball.constants.GameConstants.REPLAY;
import static baseball.constants.GameConstants.START_INCLUSIVE;
import static baseball.constants.GameConstants.START_MSG;

import baseball.domain.Computer;
import baseball.domain.Game;
import java.util.List;

public class GameController {

    private Computer computer;
    private UserInputHandler userInputHandler;
    private Validator validator;
    Boolean continueGame = true;


    public GameController() {
        computer = new Computer();
        userInputHandler = new UserInputHandler();
        validator = new Validator();
    }

    public void run() throws IllegalArgumentException {
        startGame();
        endGame();
    }

    public void startGame() throws IllegalArgumentException {
        System.out.println(START_MSG);

        computer.generateRandomNumbers(START_INCLUSIVE, END_INCLUSIVE, COUNT);

        while (continueGame) {
            System.out.print(INPUT_MSG);
            String userInput = userInputHandler.readUserInput();

            validator.checkInputSize(userInput, COUNT);
            validator.checkValidNumber(userInput);

            List<Integer> userInputNumbers = userInputHandler.parseStringNumbers(userInput);

            Game game = computer.computeResult(userInputNumbers);
            System.out.println(game.getResultString());

            if (game.isWin()) {
                continueGame = false;
            }
        }
    }

    public void endGame() {
        System.out.print(ENDGAME_MSG);
        if (Integer.parseInt(userInputHandler.readUserInput()) == REPLAY) {
            continueGame = true;
            run();
        }
    }
}
