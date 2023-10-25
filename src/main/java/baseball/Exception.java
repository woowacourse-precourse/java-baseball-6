package baseball;

import java.util.HashSet;

public class Exception {

    public static void checkInputSize(int len) {
        if (len != Game.INPUT_NUMBER_LENGTH) {
            throw new IllegalArgumentException("숫자 " + Game.INPUT_NUMBER_LENGTH + "개를 입력하세요.");
        }
    }

    public static void checkOverlap(String input, int len) {
        HashSet<String> set = new HashSet<>();
        for(int i=0; i<len; i++) {
            set.add(input.substring(i,i+1));
        }
        if (set.size() != Game.INPUT_NUMBER_LENGTH) {
            throw new IllegalArgumentException("서로 다른 " + Game.INPUT_NUMBER_LENGTH + "자리의 수를 입력하세요.");
        }
    }

    public static void inputRestartStatusValidation() {
        throw new IllegalArgumentException(Game.RESTART + "," + Game.END + " 이외의 값은 입력할 수 없습니다.");
    }

    public static void numberRangeValidation(int num) {
        if (num < Game.START_NUMBER | num > Game.LAST_NUMBER) {
            throw new IllegalArgumentException(Game.START_NUMBER + "~" + Game.LAST_NUMBER + "를 이용한 " + Game.INPUT_NUMBER_LENGTH + "자리의 수만 입력할 수 있습니다.");
        }
    }
}