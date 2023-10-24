package baseball.domain;

public enum BaseballRestartOption {
    RETRY(1),
    QUIT(2);

    private static final String OPTION_ERROR_MESSAGE = "1 혹은 2의 숫자만 입력이 가능합니다.";
    private final int option;

    BaseballRestartOption(int option) {
        this.option = option;
    }
    public static BaseballRestartOption from(int input) {
        for (BaseballRestartOption option : values()) {
            if (option.option == input) {
                return option;
            }
        }
        throw new IllegalArgumentException(OPTION_ERROR_MESSAGE);
    }
}