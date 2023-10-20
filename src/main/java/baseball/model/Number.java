package baseball.model;

import static baseball.config.Config.NUMBER_LENGTH;
import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static java.util.stream.Collectors.joining;

import baseball.view.InputView;
import java.util.List;

public class Number {

    private String number;

    private Number(String number) {
        validateNumber(number);
        validateNumberLength(number, NUMBER_LENGTH);
        this.number = number;
    }

    /**
     * Static Factory Method - 랜덤 숫자 생성
     * @param numberLength
     */
    public static Number generateRandomNumber(final int numberLength) {
        List<Integer> pickedInteger = pickUniqueNumbersInRange(1, 9, numberLength);
        String number = convertIntegerListToString(pickedInteger);
        return new Number(number);
    }

    public static Number inputPlayerNumber() {
        String number = InputView.requestUserNumber();
        return new Number(number);
    }

    private static String convertIntegerListToString(List<Integer> pickedInteger) {
        return pickedInteger.stream()
            .map(Object::toString)
            .collect(joining(""));
    }

    private void validateNumber(final String number) {
        if (number.isEmpty()) {
            throw new IllegalArgumentException("number cannot be empty");
        }
        if (!isValidNumber(number)) {
            throw new IllegalArgumentException("number cannot contain any letters");
        }
        if (!isUniqueNumber(number)) {
            throw new IllegalArgumentException("number cannot contain duplicated numbers");
        }
    }

    private void validateNumberLength(final String number, final int numLength) {
        if (!isValidLength(number, numLength)) {
            throw new IllegalArgumentException(
                "number Length is different from the system setting");
        }
    }

    private boolean isValidLength(final String number, int numLength) {
        return number.length() == numLength;
    }

    private boolean isValidNumber(final String number) {
        return number
            .chars()
            .allMatch(c -> Character.isDigit(c) && c >= '1' && c <= '9');
    }

    private boolean isUniqueNumber(final String number) {
        return number.chars().distinct().count() == number.length();
    }
}
