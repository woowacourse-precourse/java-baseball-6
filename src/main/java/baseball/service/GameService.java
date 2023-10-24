package baseball.service;

import baseball.utils.Constant;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GameService {

    private InputValidator validator;
    private List<Integer> randomNumbers;

    public GameService() {
        this.validator = new InputValidator();
        this.randomNumbers = generateNumbers();
    }

    private List<Integer> generateNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < Constant.RANDOM_NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(Constant.RANDOM_NUMBER_START,
                    Constant.RANDOM_NUMBER_END);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    public String validateInput(String userInput) {
        validator.validate(userInput);
        return generateResultMessage(userInput);
    }

    private String generateResultMessage(String userInput) {
        int ballCount = Constant.COUNT_ZERO;
        int strikeCount = Constant.COUNT_ZERO;

        for (int i = Constant.COUNT_ZERO; i < userInput.length(); i++) {
            if (isStrike(userInput, i)) {
                strikeCount++;
            } else if (isBall(userInput, i)) {
                ballCount++;
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

    private String getResultMessage(int ballCount, int strikeCount) {
        if (strikeCount == Constant.COUNT_ZERO && ballCount == Constant.COUNT_ZERO) {
            return "낫싱";
        }

        StringBuilder resultMessageBuilder = new StringBuilder();

        if (ballCount > Constant.COUNT_ZERO) {
            resultMessageBuilder.append(ballCount).append("볼 ");
        }

        if (strikeCount > Constant.COUNT_ZERO) {
            resultMessageBuilder.append(strikeCount).append("스트라이크");
        }

        return resultMessageBuilder.toString().trim();
    }
}