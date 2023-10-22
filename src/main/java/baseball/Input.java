package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private final String noNumericMessage = "숫자가 아닌 값입니다. 숫자를 입력해주세요.";
    private final String outOfRangeMessage = "3자리 자연수를 입력해주세요.";
    private final String wrongResetFlagMessage = "잘못된 숫자입니다. 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public String readUserNumber() {
        String userNumber = Console.readLine();
        if (!isNumber(userNumber)) {
            throw new IllegalArgumentException(noNumericMessage);
        }
        if (!isInRange(userNumber, 100, 999)) {
            throw new IllegalArgumentException(outOfRangeMessage);
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

    boolean isNumber(String userNumber) {
        try {
            Integer.parseInt(userNumber);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    boolean isInRange(String userNumber, int startRange, int endRange) {
        int number = Integer.parseInt(userNumber);
        if (number >= startRange && number <= endRange) {
            return true;
        } else {
            return false;
        }
    }
}
