package baseball;

import camp.nextstep.edu.missionutils.Console;

import static baseball.Validator.*;

public class Input {
    private final String noNumericMessage = "숫자가 아닌 값입니다. 숫자를 입력해주세요.";
    private final String outOfRangeMessage = "3자리 자연수를 입력해주세요.";
    private final String wrongResetFlagMessage = "잘못된 숫자입니다. 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private final String duplicateNumberMessage = "각 자리의 숫자는 서로 달라야합니다.";

    public String readUserNumber() {
        String userNumber = Console.readLine();
        if (!isNumber(userNumber)) {
            throw new IllegalArgumentException(noNumericMessage);
        }
        if (!isInRange(userNumber, 100, 999)) {
            throw new IllegalArgumentException(outOfRangeMessage);
        }
        if (!isDigitsUnique(userNumber)) {
            throw new IllegalArgumentException(duplicateNumberMessage);
        }
        return userNumber;
    }

    public boolean isRestart() {
        String restartNumber = Console.readLine();
        if (!isNumber(restartNumber)) {
            throw new IllegalArgumentException(noNumericMessage);
        }
        if (!isInRange(restartNumber, 1, 2)) {
            throw new IllegalArgumentException(wrongResetFlagMessage);
        }
        if (restartNumber.equals("1")) {
            return true;
        }
        return false;
    }


}
