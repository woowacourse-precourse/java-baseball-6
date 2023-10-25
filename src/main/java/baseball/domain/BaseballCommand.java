package baseball.domain;

import java.util.Arrays;

public enum BaseballCommand {
    RETRY("1"),
    QUIT("2");

    private final String commandIndex;

    BaseballCommand(String commandIndex) {
        this.commandIndex = commandIndex;
    }

    public static BaseballCommand confirm(String commandIndex) {
        return Arrays.stream(values())
                .filter(baseballCommand -> baseballCommand.commandIndex.equals(commandIndex))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 존재하지 않는 인덱스입니다. (1: 재시작, 2: 종료 만 입력할 수 있습니다.)"));
    }
}
