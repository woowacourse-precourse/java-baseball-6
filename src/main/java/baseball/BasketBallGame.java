package baseball;

import java.util.ArrayList;
import java.util.List;

public class BasketBallGame {

    public void playBasketBallGame() {
        RandomGenerator randomGenerator = new RandomGenerator();
        List<Integer> computerNumber = randomGenerator.createRandomNumber();

        while (true) {
            String userInputNumber = InputView.getInputNumber();

            Validator validator = new Validator();
            validator.validateUserInputNumber(userInputNumber);

            List<Integer> userNumber = setStringToListInteger(userInputNumber);

            int[] strikeAndBallCount = getStrikeAndBallCount(computerNumber, userNumber);
            OutputView.showGameResult(strikeAndBallCount);

            if (strikeAndBallCount[Constants.STRIKE_INDEX] == Constants.NUMBER_SIZE) {
                OutputView.finishGame();
                break;
            }
        }
    }

    public List<Integer> setStringToListInteger(String userInputNumber) {
        List<Integer> userNumber = new ArrayList<>();
        for (char digit : userInputNumber.toCharArray()) {
            userNumber.add(Character.getNumericValue(digit));
        }
        return userNumber;
    }

    public int[] getStrikeAndBallCount(List<Integer> computerNumber,
        List<Integer> userNumber) {
        int[] strikeAndBallCount = new int[2];
        for (int index = 0; index < Constants.NUMBER_SIZE; index++) {
            if (computerNumber.get(index) == userNumber.get(index)) {
                strikeAndBallCount[Constants.STRIKE_INDEX]++;
                continue;
            }
            if (computerNumber.contains(userNumber.get(index))) {
                strikeAndBallCount[Constants.BALL_INDEX]++;
            }
        }
        return strikeAndBallCount;
    }
}
