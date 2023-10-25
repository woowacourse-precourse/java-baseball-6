package baseball.controller;

import static baseball.utils.NumberUtils.getDigits;
import static baseball.utils.Validator.validateEndInput;
import static baseball.utils.Validator.validateNumberInput;

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

        while (true) {
            baseballView.displayMessage(MessageType.START);

            GameResult gameResult = baseballModel.gameResult;

            List<Integer> computerNumber = baseballModel.generateRandomUniqueNumbers();
            /** For debugging purpose */
            System.out.println("컴퓨터: " + computerNumber);

            while (!gameResult.isGameEnded()) {
                List<Integer> playerNumber = getPlayerNumberInput();

                gameResult = baseballModel.calculateGameResult(computerNumber, playerNumber);

                baseballView.displayScore(gameResult);

                gameResult.resetCounts();
            }
            if (!askForRestart(gameResult)) {
                break;
            }
        }
    }

    private boolean askForRestart(GameResult gameResult) {
        String endInput = getEndGameInput();

        if (endInput.equals(MessageType.RESTART.getMessage())) {
            gameResult.restartGame();
            return true;
        } else if (endInput.equals(MessageType.FINISH.getMessage())) {
            baseballView.displayMessage(MessageType.GAME_ENDED);
            return false;
        }
        return false;
    }

    private List<Integer> getPlayerNumberInput() {
        baseballView.displayMessage(MessageType.ASK_FOR_NUMBER);
        String input = baseballView.readInput();
        validateNumberInput(input);

        return getDigits(Integer.parseInt(input));
    }

    private String getEndGameInput() {
        baseballView.displayMessage(MessageType.ASK_FOR_RESTART);
        String endInput = baseballView.readInput();
        validateEndInput(endInput);

        return endInput;
    }
}

