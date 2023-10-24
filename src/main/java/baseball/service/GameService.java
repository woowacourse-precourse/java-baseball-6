package baseball.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class GameService {

    private InputValidator validator;
    private List<Integer> randomNumbers;

    public GameService() {
        this.validator = new InputValidator();
        this.randomNumbers = Randoms.pickUniqueNumbersInRange(1, 9, 3);
    }

    public String validateInput(String userInput) {
        validator.validate(userInput);
        return checkResult(userInput);
    }

    private String checkResult(String userInput) {
        int ballCount = 0;
        int strikeCount = 0;

        for (int i = 0; i < userInput.length(); i++) {
            if (isBall(userInput, i)) {
                ballCount++;
            } else if (isStrike(userInput, i)) {
                strikeCount++;
            }
        }
        return getResultMessage(ballCount, strikeCount);
    }

    private boolean isStrike(String userInput, int index) {
        return Character.getNumericValue(userInput.charAt(index)) == randomNumbers.get(index);
    }

    private boolean isBall(String userInput, int index) {
        int number = Character.getNumericValue(userInput.charAt(index));
        return randomNumbers.contains(number) && !isStrike(userInput, index);
    }

    private boolean isNothing(int ballCount, int strikeCount) {
        return strikeCount == 0 && ballCount == 0;
    }

    private String getResultMessage(int ballCount, int strikeCount) {
        if (isNothing(ballCount, strikeCount)) {
            return "낫싱";
        }

        String resultStrikeMessage = "";
        String resultBallMessage = "";

        if (ballCount > 0) {
            resultBallMessage = ballCount + "볼";
        }

        if (strikeCount > 0) {
            resultStrikeMessage = strikeCount + "스트라이크";
        }
        return resultBallMessage +" "+ resultStrikeMessage;
    }
}