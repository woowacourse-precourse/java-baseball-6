package baseball;

import static baseball.GameConstants.COUNT;
import static baseball.GameConstants.ENDGAME_MSG;
import static baseball.GameConstants.END_INCLUSIVE;
import static baseball.GameConstants.INPUT_MSG;
import static baseball.GameConstants.REPLAY;
import static baseball.GameConstants.START_INCLUSIVE;
import static baseball.GameConstants.START_MSG;

import baseball.domain.Computer;
import baseball.domain.Game;
import java.util.List;

public class GameController {

    private Computer computer;
    private UserInputHandler userInputHandler;
    //Boolean isWin = false;
    Boolean continueGame = true;


    public GameController() {
        computer = new Computer();
        userInputHandler = new UserInputHandler();
    }

    public void run() throws IllegalArgumentException {
        startGame();
        endGame();
    }

    public void startGame() throws IllegalArgumentException {
        System.out.println(START_MSG);

        List<Integer> randomNumbers = computer.generateRandomNumbers(START_INCLUSIVE, END_INCLUSIVE, COUNT);
        System.out.println("###randomNumbers = " + randomNumbers);

        System.out.println(INPUT_MSG);
        while (continueGame) {
            String userInput = userInputHandler.readUserInput();
            System.out.println("###userInput = " + userInput);
            List<Integer> userInputNumbers = userInputHandler.parseStringNumbers(userInput);

            if (userInputNumbers.size() != COUNT) {
                throw new IllegalArgumentException("사용자 입력값의 크기가 같지 않습니다.");
            }

            Game game = computer.computeResult(userInputNumbers);
            System.out.println(game.getResultString());

            if (game.isWin()) {
                continueGame = false;
            }
        }
    }

    public void endGame() {
        System.out.print(ENDGAME_MSG);
        if (userInputHandler.getInputNum() == REPLAY) {
            continueGame = true;
            run();
        }
    }
}
