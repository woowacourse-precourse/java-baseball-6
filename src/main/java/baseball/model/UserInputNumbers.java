package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class UserInputNumbers {

    private final int INPUT_NUMBER_LENGTH = 3;

    private final List<Number> userInputNumbers;
    private int strikeCount = 0;
    private int ballCount = 0;

    public UserInputNumbers(String userInput) {
        this.userInputNumbers = userInputToNumbers(userInput);
    }

    private List<Number> userInputToNumbers(String userInput) {
        List<Number> inputNumbers = new ArrayList<>();
        for (char numberCharacter : userInput.toCharArray()) {
            inputNumbers.add(new Number(Character.getNumericValue(numberCharacter)));
        }
        return inputNumbers;
    }

    public int countStrikes(RandomNumbers randomNumbers) {
        List<Number> randomNumberList = randomNumbers.getRandomNumbers();
        for (int i = 0; i < INPUT_NUMBER_LENGTH; i++) {
            Number userInputNumber = userInputNumbers.get(i);
            Number randomNumber = randomNumberList.get(i);

            if (userInputNumber.equals(randomNumber)) {
                strikeCount += 1;
            }
        }
        return strikeCount;
    }

    public int countBalls(RandomNumbers randomNumbers) {
        List<Number> randomNumberList = randomNumbers.getRandomNumbers();
        for (int i = 0; i < INPUT_NUMBER_LENGTH; i++) {
            Number userInputNumber = userInputNumbers.get(i);
            if (randomNumberList.contains(userInputNumber) && !randomNumberList.get(i).equals(userInputNumber)) {
                ballCount += 1;
            }
        }
        return ballCount;
    }
}
