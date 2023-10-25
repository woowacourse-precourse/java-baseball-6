package baseball.controller.constant;

import java.util.Arrays;

public enum GameCommand {
    RESTART("1"),
    EXIT("2");

    private final String number;

    GameCommand(String number) {
        this.number = number;
    }

    public static GameCommand from(String command) {
        return Arrays.stream(values())
                .filter(code -> code.number.equals(command))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 코드를 입력하셨습니다."));
    }

}
