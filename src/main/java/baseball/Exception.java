package baseball;


import java.util.HashSet;

public class Exception {
    private static final int INPUT_NUMBER_LENGTH = 3;
    private static final int RESTART = 1;
    private static final int END = 2;
    private static final int START_NUMBER = 1;
    private static final int LAST_NUMBER = 9;

    public static void checkInputSize(int len) {
        if (len != INPUT_NUMBER_LENGTH) {
            throw new IllegalArgumentException("숫자 " + INPUT_NUMBER_LENGTH + "개를 입력하세요.");
        }
    }

    public static void checkOverlap(String input, int len) {
        HashSet<String> set = new HashSet<>();
        for(int i=0; i<len; i++) {
            set.add(input.substring(i,i+1));
        }
        if (set.size() != INPUT_NUMBER_LENGTH) {
            throw new IllegalArgumentException("서로 다른 " + INPUT_NUMBER_LENGTH + "자리의 수를 입력하세요.");
        }
    }

    public static void inputRestartStatusValidation() {
        throw new IllegalArgumentException(RESTART + "," + END + " 이외의 값은 입력할 수 없습니다.");
    }

    public static void numberRangeValidation(int num) {
        if (num < START_NUMBER | num > LAST_NUMBER) {
            throw new IllegalArgumentException(START_NUMBER + "~" + LAST_NUMBER + "를 이용한 " + INPUT_NUMBER_LENGTH + "자리의 수만 입력할 수 있습니다.");
        }
    }
}