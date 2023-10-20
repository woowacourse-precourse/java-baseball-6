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

    public boolean isEqualInputString(String inputString) {
        return getInputString().equals(inputString);
    }


    public String getInputString() {
        return inputString;
    }

    public boolean isContinue() {
        return isContinue;
    }
}
