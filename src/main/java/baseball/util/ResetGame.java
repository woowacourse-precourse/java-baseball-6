package baseball.util;

import baseball.view.Input;
import baseball.util.ThrowError;
public class ResetGame {
    public static boolean isReset () throws IllegalArgumentException {
        int input = Integer.parseInt(String.valueOf(Input.printResetGame()));
        if(input == 1) {
            return true;
        } else if (input == 2) {
            return false;
        } else {
            throw new IllegalArgumentException("1또는 2를 입력해 주시길 바랍니다.");
        }
    }
}
