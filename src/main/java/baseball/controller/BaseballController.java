package baseball.controller;

import static baseball.utils.NumberUtils.getDigits;
import static baseball.utils.Validator.validateEndInput;
import static baseball.utils.Validator.validateInput;

import baseball.entity.GameResult;
import baseball.enums.MessageType;
import baseball.model.BaseballModel;
import baseball.view.BaseballView;
import java.util.List;

public class BaseballController {
    private BaseballModel baseballModel;
    private BaseballView baseballView;

    public BaseballController(BaseballModel baseballModel, BaseballView baseballView) {
        this.baseballModel = baseballModel;
        this.baseballView = baseballView;
    }

    public void startGame() {
        baseballView.displayMessage(MessageType.START);

        GameResult gameResult = baseballModel.gameResult;

        List<Integer> computerNumber = baseballModel.generateRandomNumbers();
        // For debugging purpose
        System.out.println("컴퓨터: " + computerNumber);

        while (!gameResult.isGameEnded()) {
            List<Integer> playerNumber = getPlayerInput();

            gameResult = baseballModel.evaluatePlayerInput(computerNumber, playerNumber);

            baseballView.displayScore(gameResult);

            gameResult.resetCounts();
        }
        askForRestart(gameResult);
    }

    private void askForRestart(GameResult gameResult) {
        baseballView.displayMessage(MessageType.ASK_FOR_RESTART);

        String endInput = getPlayerEndInput();

        if (endInput.equals(MessageType.RESTART.getMessage())) {
            gameResult.restartGame();
            startGame();
        } else if (endInput.equals(MessageType.FINISH.getMessage())) {
            baseballView.displayMessage(MessageType.GAME_ENDED);
        }
    }

    public List<Integer> getPlayerInput() {
        baseballView.displayMessage(MessageType.ASK_FOR_NUMBER);
        String input = baseballView.readInput();
        validateInput(input);

        return getDigits(Integer.parseInt(input));
    }

    public String getPlayerEndInput() {
        String endInput = baseballView.readInput();
        validateEndInput(endInput);

        return endInput;
    }
}

