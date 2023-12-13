package baseball.dto;

import java.util.Arrays;

public enum TerminateEnum {
    RESTART(1),
    EXIT(2);

    private final int value;

    TerminateEnum(int value) {
        this.value = value;
    }

    public static TerminateEnum findTerminateEnumByValue(int value) {
        return Arrays.stream(TerminateEnum.values())
                .filter(terminateEnum -> terminateEnum.value == value)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 종료조건을 입력했습니다. 재시작은 1, 종료는 2"));
    }

}
