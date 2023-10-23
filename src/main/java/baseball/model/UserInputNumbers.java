package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class UserInputNumbers {

    private final int INPUT_NUMBER_LENGTH = 3;

    private final List<Number> userNumberList;
    private int strikeCount = 0;
    private int ballCount = 0;

    public UserInputNumbers(String userInput) {
        this.userNumberList = userInputToNumbers(userInput);
    }

    private List<Number> userInputToNumbers(String userInput) {
        List<Number> numberList = new ArrayList<>();
        for (char numberCharacter : userInput.toCharArray()) {
            Number inputNumber = new Number(Character.getNumericValue(numberCharacter));
            numberList.add(inputNumber);
        }
        return numberList;
    }

    public int countStrikes(RandomNumbers randomNumbers) {
        List<Number> randomNumberList = randomNumbers.getRandomNumbers();
        for (int i = 0; i < INPUT_NUMBER_LENGTH; i++) {
            Number userInputNumber = userNumberList.get(i);
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
            Number userInputNumber = userNumberList.get(i);
            if (randomNumberList.contains(userInputNumber) && !randomNumberList.get(i).equals(userInputNumber)) {
                ballCount += 1;
            }
        }
        return ballCount;
    }
}
