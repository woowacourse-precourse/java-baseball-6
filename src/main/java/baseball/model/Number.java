package baseball.model;

import static baseball.config.Config.NUMBER_LENGTH;
import static baseball.validator.NumberValidator.validateNumber;
import static baseball.validator.NumberValidator.validateNumberLength;
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
     *
     * @param numberLength
     */
    public static Number generateRandomNumber(final int numberLength) {
        List<Integer> pickedInteger = pickUniqueNumbersInRange(1, 9, numberLength);
        String number = convertIntegerListToString(pickedInteger);
        return new Number(number);
    }

    /**
     * Static Factory Method - 사용자 숫자 입력
     */
    public static Number inputPlayerNumber() {
        String number = InputView.requestUserNumber();
        return new Number(number);
    }

    public int countBallCount(final Number coumputerNumber) {
        return 1;
    }

    public int countStrikeCount(final Number computerNumber) {
        return 1;
    }

    private static String convertIntegerListToString(List<Integer> pickedInteger) {
        return pickedInteger.stream()
            .map(Object::toString)
            .collect(joining(""));

    }
}
