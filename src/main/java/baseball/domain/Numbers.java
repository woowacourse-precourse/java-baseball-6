package baseball.domain;

import baseball.view.InputView;

import java.util.ArrayList;
import java.util.List;

import static baseball.config.NumberConfig.*;
import static baseball.validator.NumberValidator.*;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static java.lang.String.valueOf;

public class Numbers {
    private final List<Integer> number;

    // Player Number Constructor
    private Numbers(String input) {
        validateEmpty(input);
        validateNumberLength(input);
        validateContainOnlyNumber(input);
        validateContainDuplicatedNumber(input);

        this.number = convertInputNumbers(input);
    }

    // Computer Number Constructor
    private Numbers(List<Integer> computerNumber) {
        this.number = computerNumber;
    }

    // Player Number Static Factory Method
    public static Numbers inputPlayerNumbers() {
        String playerNumbers = InputView.requestUserNumbers();
        return new Numbers(playerNumbers);
    }

    // Computer Number Static Factory Method
    public static Numbers generateRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < NUMBER_LENGTH.getValue()) {
            int number = pickNumberInRange(NUMBER_MINIMUM_INCLUSIVE.getValue(), NUMBER_MAXIMUM_INCLUSIVE.getValue());
            if (!randomNumbers.contains(number)) {
                randomNumbers.add(number);
            }
        }
        return new Numbers(randomNumbers);
    }

    public int countBallCount(final Numbers computerNumbers) {
        int ballCount = 0;
        for (int i = 0; i < playerNumber.length(); i++) {
            char playerDigit = playerNumber.charAt(i);
            char compareDigit = compareNumber.charAt(i);

            if (playerDigit != compareDigit && compareNumber.contains(valueOf(playerDigit))) {
                ballCount++;
            }
        }
        return ballCount;
    }

    public int countStrikeCount(final Numbers computerNumber) {
        int strikeCount = 0;
        String playerNumber = this.getInput();
        String compareNumber = computerNumber.getInput();

        for (int i = 0; i < NUMBER_LENGTH.getValue(); i++) {
            if (playerNumber.charAt(i) == compareNumber.charAt(i)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private List<Integer> convertInputNumbers(String input) {
        return input.chars()
                .filter(Character::isDigit)
                .mapToObj(Character::getNumericValue)
                .toList();
    }
}
