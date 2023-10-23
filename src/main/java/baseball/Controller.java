package baseball;

import static baseball.utils.NumberUtils.getDigits;
import static baseball.utils.Validator.validateEndInput;
import static baseball.utils.Validator.validateInput;

import baseball.entity.GameResult;
import baseball.enums.MessageType;
import java.util.List;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void startGame() {
        view.displayMessage(MessageType.START);

        GameResult gameResult = model.gameResult;

        List<Integer> computerNumber = model.generateRandomNumbers();
        // For debugging purpose
        System.out.println("컴퓨터: " + computerNumber);

        while (!gameResult.isGameEnded()) {

            List<Integer> playerNumber = getPlayerInput();

            gameResult = model.evaluatePlayerInput(computerNumber, playerNumber);

            view.displayScore(gameResult);

            gameResult.resetCounts();
        }

        askForRestart(gameResult);
    }

    private void askForRestart(GameResult gameResult) {
        view.displayMessage(MessageType.ASK_FOR_RESTART);

        String endInput = getPlayerEndInput();

        if (endInput.equals(MessageType.RESTART.getMessage())) {
            gameResult.restartGame();
            startGame();
        } else if (endInput.equals(MessageType.FINISH.getMessage())) {
            view.displayMessage(MessageType.GAME_ENDED);
        }
    }

    public List<Integer> getPlayerInput() {
        view.displayMessage(MessageType.ASK_FOR_NUMBER);
        String input = view.readInput();
        validateInput(input);

        return getDigits(Integer.parseInt(input));
    }

    public String getPlayerEndInput() {
        String endInput = view.readInput();
        validateEndInput(endInput);

        return endInput;
    }
}

