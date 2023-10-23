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

            if (isStrike(userInputNumber, randomNumber)) {
                strikeCount += 1;
            }
        }
        return strikeCount;
    }


    public int countBalls(RandomNumbers randomNumbers) {
        List<Number> randomNumberList = randomNumbers.getRandomNumbers();
        for (int i = 0; i < INPUT_NUMBER_LENGTH; i++) {
            Number userInputNumber = userNumberList.get(i);
            Number randomNumber = randomNumberList.get(i);

            if (isBall(randomNumberList, userInputNumber, randomNumber)) {
                ballCount += 1;
            }
        }
        return ballCount;
    }

    private boolean isStrike(Number userInputNumber, Number randomNumber) {
        return userInputNumber.equals(randomNumber);
    }

    private boolean isBall(List<Number> randomNumberList, Number userInputNumber, Number randomNumber) {
        return randomNumberList.contains(userInputNumber) && !isStrike(randomNumber, userInputNumber);
    }
}
