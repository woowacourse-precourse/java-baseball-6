package baseball.model;

import baseball.rules.InputValidator;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.rules.GameConstants.MAX_NUMBER;
import static baseball.rules.GameConstants.MIN_NUMBER;
import static baseball.rules.GameConstants.NUMBER_OF_DIGITS;

public class Numbers {
    private final List<Integer> numbers;

    public Numbers() {
        this.numbers = new ArrayList<>(NUMBER_OF_DIGITS);
    }

    static Numbers createRandomNumbers() {
        Numbers numbers = new Numbers();
        numbers.generateRandomNumbers();
        return numbers;
    }

    static Numbers createPlayerNumbersFromInput(String input) {
        InputValidator.validatePlayerNumbers(input);

        Numbers numbers = new Numbers();
        numbers.initPlayerNumbers(input);
        return numbers;
    }

    private void generateRandomNumbers() {
        this.numbers.clear();
        while (this.numbers.size() < NUMBER_OF_DIGITS) {
            int randomNumber = generateRandomNumber();

            if (!isDuplicated(randomNumber)) {
                this.numbers.add(randomNumber);
            }
        }
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }

    private boolean isDuplicated(int randomNumber) {
        return this.numbers.contains(randomNumber);
    }

    private void initPlayerNumbers(String playerInput) {
        this.numbers.clear();

        for (String number : playerInput.split("")) {
            this.numbers.add(Integer.parseInt(number));
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
