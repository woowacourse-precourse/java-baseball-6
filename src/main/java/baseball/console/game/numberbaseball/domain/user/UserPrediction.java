package baseball.console.game.numberbaseball.domain.user;

import baseball.console.game.numberbaseball.util.NumberUtils;

import java.util.ArrayList;
import java.util.List;

public class UserPrediction {
    private int userNumber;
    private List<Integer> userNumbers;

    public UserPrediction(String userPrediction) {
        UserPredictionValidator.validate(userPrediction);
        parseStringToInt(userPrediction);
        intToList(userNumber);
    }
    private void parseStringToInt(String userPrediction) {
       userNumber = Integer.parseInt(userPrediction);
    }

    private void intToList(int userNumber) {
        userNumbers = new ArrayList<>();
        userNumbers.add(NumberUtils.getHundredDigit(userNumber));
        userNumbers.add(NumberUtils.getTenDigit(userNumber));
        userNumbers.add(NumberUtils.getOneDigit(userNumber));
    }

    public List<Integer> getUserNumbers() {
        return userNumbers;
    }
}
