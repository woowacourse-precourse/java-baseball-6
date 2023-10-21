package baseball.util;

import baseball.view.Input;
public class ResetGame {
    public static boolean isReset () throws IllegalAccessError {
        int input = Integer.parseInt(String.valueOf(Input.printResetGame()));
        if(input == 1) {
            return true;
        } else if (input == 2) {
            return false;
        } else {
            throw new IllegalAccessError("1또는 2를 입력해 주시길 바랍니다.");
        }
    }
}
