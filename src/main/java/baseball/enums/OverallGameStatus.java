package baseball.enums;

import java.util.Arrays;

public enum OverallGameStatus {
    CONTINUE("1", true), FINISH("2", false);

    private final String inputString;
    private final boolean isContinue;

    OverallGameStatus(String inputString, boolean isContinue) {
        this.inputString = inputString;
        this.isContinue = isContinue;
    }


    public static OverallGameStatus valueOfInputString(String inputString) {

        return Arrays.stream(values())
                .filter(status -> status.isEqualInputString(inputString))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 잘못된 입력입니다."));
    }

    private boolean isEqualInputString(String inputString) {
        return this.inputString.equals(inputString);
    }


    public boolean isContinue() {
        return isContinue;
    }
}
