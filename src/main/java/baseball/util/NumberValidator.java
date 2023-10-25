package baseball.util;

import baseball.game.GameCommand;
import baseball.number.Number;

/**
 * User가 숫자 입력을 받을 때, User가 재시작 투표를 할 때 받는 input에 대해 유효성 검사를 하는 유틸이다.
 *
 * @author Seongha Park
 */
public class NumberValidator {
    /**
     * 재시작 투표 시, 1(재시작) 또는 2(종료)가 아니라면 에러를 반환한다.
     *
     * @param inputNumber 재시작 투표 시 User에게 받은 input이다.
     * @throws IllegalArgumentException
     */
    public static void validateInput(int inputNumber) {
        if (inputNumber != GameCommand.RESTART.getCommandValue() && inputNumber != GameCommand.END.getCommandValue()) {
            throw new IllegalArgumentException("재시작(1) 혹은 종료(2)를 입력해주세요.");
        }
    }

    /**
     * User에게 받은 입력값들은 String으로 되어있기 때문에 이를 Number로 변환해주는 함수이다.
     *
     * @param obj 사용자에게 입력받은 input이다.
     * @return 사용자에게 입력받은 input을 Number로 변환한 결과이다.
     * @throws IllegalArgumentException
     */
    public static Number convertToNumber(String obj) {
        try {
            int parsedNumber = Integer.parseInt(obj);
            Number number = new Number(parsedNumber);

            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자를 입력해주세요.");
        }
    }

    /**
     * 숫자 자체가 1이상 9이하의 값을 나타내는지 확인한다.
     *
     * @param number 유효성을 확인할 숫자이다.
     * @throws IllegalArgumentException
     */
    public static void checkNumberValidate(Number number) {
        int num = number.number();
        if (num < 1 || num > 9) {
            throw new IllegalArgumentException("1이상 9이하의 값을 입력해주세요.");
        }
    }
}
