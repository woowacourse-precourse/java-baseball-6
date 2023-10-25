package baseball.constant;

import static baseball.constant.ExceptionMessage.TYPE;

import java.util.Arrays;

/**
 * {@summary 게임 재시작과 종료에 관련된 상수를 다룬다.}
 */
public enum Command {
    RESTART("1"),
    QUIT("2");

    private final String value;

    Command(String value) {
        this.value = value;
    }

    /**
     * {@link String}으로 주어진 value에 맞는 enum을 리턴하는 메서드. 일치하는 enum이 없다면 {@link IllegalArgumentException}을 throw한다.
     *
     * @param cmd 문자열로 주어진 커맨드
     * @return 주어진 문자열과 value가 일치하는 enum
     * @throws IllegalArgumentException 일치하는 enum이 존재하지 않을 경우 발생
     */
    public static Command of(String cmd) {
        return Arrays.stream(values()).filter(elem -> cmd.equals(elem.value)).findFirst()
                .orElseThrow(() -> new IllegalArgumentException(TYPE.build(cmd)));
    }
}
