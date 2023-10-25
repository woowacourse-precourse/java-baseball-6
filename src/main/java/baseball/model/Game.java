package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import baseball.utils.Constant;
import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Integer> randomNumbers;

    public Game() {
        this.randomNumbers = generateNumbers();
    }

    private List<Integer> generateNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < Constant.RANDOM_NUMBER_SIZE) {
            addUniqueRandomNumber(numbers);
        }
        return numbers;
    }

    private void addUniqueRandomNumber(List<Integer> numbers) {
        int randomNumber;
        do {
            randomNumber = Randoms.pickNumberInRange(Constant.RANDOM_NUMBER_START,
                    Constant.RANDOM_NUMBER_END);
        } while (numbers.contains(randomNumber));

        numbers.add(randomNumber);
    }

    public boolean isStrike(String userInput, int index) {
        return Character.getNumericValue(userInput.charAt(index)) == randomNumbers.get(index);
    }

    public boolean isBall(String userInput, int index) {
        int number = Character.getNumericValue(userInput.charAt(index));
        return randomNumbers.contains(number) && !isStrike(userInput, index);
    }

    public int calculateBall(String userInput, int index) {
        return (!isStrike(userInput, index) && isBall(userInput, index)) ? 1 : 0;
    }

    public int calculateStrike(String userInput, int index) {
        return isStrike(userInput, index) ? 1 : 0;
    }

}
