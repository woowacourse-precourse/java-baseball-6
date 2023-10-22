package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private final String noNumericMessage = "숫자가 아닌 값입니다. 숫자를 입력해주세요.";
    private final String outOfRangeMessage = "3자리 자연수를 입력해주세요.";

    public String readUserNumber() {
        String userNumber = Console.readLine();
        if (!isNumber(userNumber)) {
            throw new IllegalArgumentException(noNumericMessage);
        }
        if (!isInRange(userNumber)) {
            throw new IllegalArgumentException(outOfRangeMessage);
        }
        return userNumber;
    }

    public boolean isRestart() {
        String restartNumber = Console.readLine();
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

    boolean isInRange(String userNumber) {
        int number = Integer.parseInt(userNumber);
        if (number >= 100 && number <= 999) {
            return true;
        } else {
            return false;
        }
    }
}
