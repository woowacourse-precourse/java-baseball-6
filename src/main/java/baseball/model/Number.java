package baseball.model;

import baseball.view.InputView;

import java.util.ArrayList;
import java.util.List;

import static baseball.config.NumberConfig.*;
import static baseball.validator.NumberValidator.*;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static java.lang.String.valueOf;
import static java.util.stream.Collectors.joining;

public class Number {
    private final String value;

    private Number(String value) {
        validateEmpty(value);
        validateNumberLength(value);
        validateContainOnlyNumber(value);
        validateContainDuplicatedNumber(value);
        this.value = value;
    }

    public static Number generateRandomNumber() {
        List<Integer> pickedInteger = new ArrayList<>();
        while (pickedInteger.size() < NUMBER_LENGTH.getValue()) {
            int number = pickNumberInRange(NUMBER_MINIMUM_INCLUSIVE.getValue(), NUMBER_MAXIMUM_INCLUSIVE.getValue());
            if (!pickedInteger.contains(number)) {
                pickedInteger.add(number);
            }
        }
        String number = convertIntegerListToString(pickedInteger);
        return new Number(number);
    }

    public static Number inputPlayerNumber() {
        String number = InputView.requestUserNumber();
        return new Number(number);
    }

    public int countBallCount(final Number computerNumber) {
        int ballCount = 0;
        String playerNumber = this.getValue();
        String compareNumber = computerNumber.getValue();

        for (int i = 0; i < playerNumber.length(); i++) {
            char playerDigit = playerNumber.charAt(i);
            char compareDigit = compareNumber.charAt(i);

            if (playerDigit != compareDigit && compareNumber.contains(valueOf(playerDigit))) {
                ballCount++;
            }
        }
        return ballCount;
    }

    public int countStrikeCount(final Number computerNumber) {
        int strikeCount = 0;
        String playerNumber = this.getValue();
        String compareNumber = computerNumber.getValue();

        for (int i = 0; i < NUMBER_LENGTH.getValue(); i++) {
            if (playerNumber.charAt(i) == compareNumber.charAt(i)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private static String convertIntegerListToString(List<Integer> pickedInteger) {
        return pickedInteger.stream()
                .map(Object::toString)
                .collect(joining(""));
    }

    public String getValue() {
        return value;
    }
}
