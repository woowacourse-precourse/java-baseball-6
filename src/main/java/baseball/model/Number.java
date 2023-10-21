package baseball.model;

import static baseball.config.Config.NUMBER_LENGTH;
import static baseball.validator.NumberValidator.validateNumber;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static java.lang.String.valueOf;
import static java.util.stream.Collectors.joining;

import baseball.view.InputView;
import java.util.ArrayList;
import java.util.List;

public class Number {

    private String number;

    private Number(String number) {
        validateNumber(number);
        this.number = number;
    }

    public static Number generateRandomNumber(final int numberLength) {
        List<Integer> pickedInteger = new ArrayList<>();
        while (pickedInteger.size() < numberLength) {
            int number = pickNumberInRange(1, 9);
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
        int ret = 0;
        String playerNumber = this.getNumber();
        String compareNumber = computerNumber.getNumber();

        for (int i = 0; i < playerNumber.length(); i++) {
            char playerDigit = playerNumber.charAt(i);
            char compareDigit = compareNumber.charAt(i);

            if (playerDigit != compareDigit && compareNumber.contains(valueOf(playerDigit))) {
                ret++;
            }
        }
        return ret;
    }

    public int countStrikeCount(final Number computerNumber) {
        int strikeCount = 0;
        String playerNumber = this.getNumber();
        String compareNumber = computerNumber.getNumber();

        for (int i = 0; i < NUMBER_LENGTH; i++) {
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

    /**
     * getNumber() 외부 객체에서 값을 꺼내지 못하도록 private로 제한
     */
    public String getNumber() {
        return number;
    }
}
