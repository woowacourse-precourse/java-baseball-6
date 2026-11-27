package baseball.domain;

public enum RestartChoice {
    RESTART("1"),
    EXIT("2");

    private final String input;

    RestartChoice(String input) {
        this.input = input;
    }

    public static RestartChoice from(String input) {
        for (RestartChoice choice : values()) {
            if (choice.input.equals(input)) {
                return choice;
            }
        }

        throw new IllegalArgumentException("1 또는 2를 입력해야 합니다.");
    }
}
