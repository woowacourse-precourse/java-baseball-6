package baseball.constant;

import static baseball.constant.GameConstant.TOTAL_BALL_CNT;

/**
 * {@summary Exception발생 시 사용할 오류 메세지를 다룬다.}
 */
public enum ExceptionMessage {
    LENGTH("입력한 수의 길이가 길거나 짧습니다.", TOTAL_BALL_CNT.getValue()),
    TYPE("잘못된 입력입니다.", "1(재시작) 또는 2(종료)"),
    DUPLICATE("서로 다른 세 숫자를 입력해야 합니다.", 123);

    private final String message;
    private final Object expect;

    ExceptionMessage(String message, Object expect) {
        this.message = message;
        this.expect = expect;
    }

    public String getMessage() {
        return message;
    }

    public String build(Object actual) {
        return message + "\nExpect: " + expect + "\nActual: " + actual;
    }
}
