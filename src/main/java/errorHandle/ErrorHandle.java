package errorHandle;

import baseball.User;
import baseball.Computer;

public class ErrorHandle {
    final private int userInputLength = 3;


    public void checkLengthInput(String userInputNum) throws IllegalArgumentException {
        if (userInputNum.length() != userInputLength) {
            throw new IllegalArgumentException("입력한 숫자는 세자리 이어야 합니다.");
        }
    }

    public void checkSameInput(String userInputNum) throws IllegalArgumentException {
        for (int targetInputNumIndex = 0; targetInputNumIndex < userInputNum.length(); targetInputNumIndex++) {
            for (int compareNumIndex = targetInputNumIndex + 1; compareNumIndex < userInputNum.length();
                 compareNumIndex++) {
                if (userInputNum.charAt(targetInputNumIndex) == userInputNum.charAt(compareNumIndex)) {
                    throw new IllegalArgumentException("입력한 숫자는 서로 달라야 합니다.");
                }
            }
        }
    }
}
