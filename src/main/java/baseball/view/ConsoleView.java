package baseball.view;

import baseball.game.BaseballGame;
import baseball.util.ErrorMessage;
import baseball.util.InvalidCustomException;
import baseball.util.ResultMessage;

import java.util.List;

public class ConsoleView {
    private final BaseballGame game;

    public ConsoleView() {
        this.game = new BaseballGame();
    }

    public void startGame() {
        boolean playAgain = true;

        while (playAgain) {
            displayGameInstructions();
            game.initializeGame();

            while (game.isGameActive()) {
                List<Integer> guess = UserInputHandler.getIntArrayInput();
                game.playGame(guess);
            }

            int choice = UserInputHandler.getIntInput();
            switch (choice) {
                case 1 -> {}
                case 2 -> playAgain = false;
                default -> throw new InvalidCustomException(ErrorMessage.INVALID_INPUT);
            }
        }
    }

    private void displayGameInstructions() {
        System.out.println(ResultMessage.START_GAME);
        System.out.println(ResultMessage.INPUT_GAME);
    }
}
