package baseball.util;

import baseball.game.GameCommand;
import baseball.number.Number;

public class NumberValidator {
    public static void validateInput(int inputNumber) {
        if (inputNumber != GameCommand.RESTART.getCommandValue() && inputNumber != GameCommand.END.getCommandValue()) {
            throw new IllegalArgumentException("재시작(1) 혹은 종료(2)를 입력해주세요.");
        }
    }

    public static Number convertToNumber(String obj) {
        try {
            int parsedNumber = Integer.parseInt(obj);
            Number number = new Number(parsedNumber);

            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자를 입력해주세요.");
        }
    }

    public static void checkValidate(Number number) {
        int num = number.number();
        if (num < 1 || num > 9) {
            throw new IllegalArgumentException("1이상 9이하의 값을 입력해주세요.");
        }
    }
}
