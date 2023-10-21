package baseball.validation;

import baseball.exception.LengthException;
import baseball.exception.NumberException;

public class Validation {
    public static void checkLength(String input) throws LengthException {
        if (!input.matches("^.{3}$")) {
            throw new LengthException("[ERROR] 길이가 맞지 않습니다.");
        }
    }

    public static void checkNumber(String input) throws NumberException {
        if (!input.matches("^[1-9]*$")) {
            throw new LengthException("[ERROR] 숫자가 아닙니다.");
        }
    }

    public static void checkNumberIsOneOrTwo(String input) throws NumberException {
        if (!input.matches("[12]")) {
            throw new LengthException("[ERROR] 재시작 및 종료 입력은 1 또는 2이여야 합니다.");
        }
    }
}
