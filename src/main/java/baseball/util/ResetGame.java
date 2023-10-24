package baseball.util;

//게임 진행상황 관리 유틸
import baseball.view.Input;

public class ResetGame {
    public static boolean isReset () throws IllegalArgumentException {
        String input = Input.printResetGame();

        if(input.equals("1")) {
            return true;
        } else if (input.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException("1또는 2를 입력해 주시길 바랍니다.");
        }
    }
}
