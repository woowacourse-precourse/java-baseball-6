package baseball.controller;

import baseball.model.BaseballGame;
import baseball.model.Validator;
import baseball.view.UserView;

import java.util.List;

import static baseball.model.BaseballGame.stringToListOfIntegers;
import static baseball.model.Constants.*;

public class GameController {

    private final UserView userView;
    private final Validator validator;
    private final BaseballGame baseballGame;

    public GameController() {
        userView = new UserView();
        validator = new Validator();
        baseballGame = new BaseballGame();
    }

    public void playBaseballGame() {
        userView.displayStartMessage();

        playGame();

    }

    public List<Integer> validateAndParseUserNumber(String userNumber) throws IllegalArgumentException {
        if (validator.isValidNumber(userNumber)) {
            return stringToListOfIntegers(userNumber);
        }

        throw new IllegalArgumentException();
    }

    public void playGame() {
        List<Integer> computerNumber = baseballGame.getComputerNumber();

        while(true) {
            String stringUserNumber = userView.getUserNumber();

            List<Integer> userNumber = validateAndParseUserNumber(stringUserNumber);
            List<Integer> ballAndStrike = baseballGame.countBallAndStrike(computerNumber, userNumber);

            String resultMessage = BaseballGame.getResultMessage(ballAndStrike);
            userView.displayResultMessage(resultMessage);

            String restartOrEnd = restartOrEnd(resultMessage);
            if (restartOrEnd.equals("2")) {
                UserView.displayEndMessage();
                return;
            } else if (restartOrEnd.equals("1")) {
                playGame();
                return;
            }
        }
    }

    private String restartOrEnd (String resultMessage) {
        if (resultMessage.equals(GAME_NUMBER_LENGTH + STRIKE)) {
            UserView.displayWinMessage();
            String restartOrEnd = UserView.getRestartOrEnd();
            validator.validateRestartOrEndNumber(restartOrEnd);
            return restartOrEnd;
        }
        return "0";
    }
}
