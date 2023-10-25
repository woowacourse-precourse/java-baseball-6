package baseball.controller;

import baseball.model.BaseballGame;
import baseball.model.Validator;
import baseball.view.UserView;

import java.util.ArrayList;
import java.util.List;

import static baseball.model.Constants.*;

public class GameController {

    private UserView userView;
    private Validator validator;
    private BaseballGame baseballGame;

    public GameController() {
        userView = new UserView();
        validator = new Validator();
        baseballGame = new BaseballGame();
    }

    public void playBaseballGame() {
        userView.displayStartMessage();

        playGame();
    }

    public void playGame() {
        List<Integer> computerNumber = baseballGame.getComputerNumber();

        while(true) {
            String stringUserNumber = userView.getUserNumber();

            List<Integer> userNumber = validateAndParseUserNumber(stringUserNumber);
            List<Integer> ballAndStrike = baseballGame.countBallAndStrike(computerNumber, userNumber);

            String resultMessage = BaseballGame.getResultMessage(ballAndStrike);
            userView.displayResultMessage(resultMessage);
            
            //TODO 재시작/종료

        }
    }

    public List<Integer> validateAndParseUserNumber(String userNumber) throws IllegalArgumentException {
        if (validator.isValidNumber(userNumber)) {
            return stringToListOfIntegers(userNumber);
        }

        throw new IllegalArgumentException();
    }

    public static List<Integer> stringToListOfIntegers(String userNumber) {
        List<Integer> integerList = new ArrayList<>();

        for (int i = 0; i < userNumber.length(); i++) {
            char digitChar = userNumber.charAt(i);
            int digit = Character.getNumericValue(digitChar);
            integerList.add(digit);
        }

        return integerList;
    }
}
