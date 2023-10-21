package baseball;

import java.util.List;

import static baseball.constant.NumberConstant.*;
import static baseball.constant.TextConstant.*;

public class Application {

    public static void main(final String[] args) {
        System.out.println(INIT_GAME_MESSAGE);
        NumberCreator numberCreator = NumberCreator.initGame();
        GameManager gameManager = GameManager.initGame();

        List<Integer> computerNumber = numberCreator.getComputerNumber();

        while (true) {
            System.out.print(NUMBER_INPUT_MESSAGE);
            List<Integer> guessNumber = numberCreator.getGuessNumber();
            int correctCount = gameManager.playGame(computerNumber, guessNumber);

            if (correctCount == SUCCESS_GUESS) {
                boolean exitGame = gameManager.getNextGameState();
                if (exitGame) {
                    break;
                }

                computerNumber = numberCreator.getComputerNumber();
            }
        }
    }
}
