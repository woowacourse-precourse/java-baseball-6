package baseball.view;

import java.util.Arrays;

public enum Command {
    RESTART("1"),
    FINISH("2");

    private final String value;

    Command(String value) {
        this.value = value;
    }

    public static Command findByString(String string) {
        return Arrays.stream(Command.values())
                .filter(command -> command.value.equals(string))
                .findFirst()
                .orElseThrow(()-> new IllegalArgumentException("잘못된 입력입니다."));
    }
}
