package baseball.domain;

public class ReGameCommand {
    private String value;
    public static final String RESTART = "1";
    public static final String EXIT = "2";

    public ReGameCommand(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        if (!value.equals(RESTART) && !value.equals(EXIT)) {
            throw new IllegalArgumentException("1또는 2를 입력해야합니다.");
        }
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof ReGameCommand) {
            return this.value.equals(((ReGameCommand) object).value);
        }
        return false;
    }
}
