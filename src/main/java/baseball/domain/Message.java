package baseball.domain;

public enum Message {

    // 문구 메시지
    START("숫자 야구 게임을 시작합니다."),
    INPUT("숫자를 입력해주세요 : "),
    END_OR_START("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),


    // 힌트 메시지
    NOTHING("낫싱"),
    ONE_BALL("1볼"),
    ONE_BALL_ONE_STRIKE("1볼 1스트라이크"),
    TWO_BALL("2볼"),
    TWO_BALL_ONE_STRIKE("2볼 1스트라이크"),
    THREE_BALL("3볼"),
    ONE_STRIKE("1스트라이크"),
    TWO_STRIKE("2스트라이크"),
    THREE_STRIKE("3스트라이크"),


    // 예외 관련 메시지
    NOT_NUMBER_EXCEPTION("입력된 값이 숫자가 아닙니다."),
    OUT_OF_RANGE_EXCEPTION("입력된 값이 범위를 초과하였습니다."),
    OUT_OF_HINT_NUMBER_EXCEPTION("입력된 값은 1~9까지만 가능합니다. (0은 입력할 수 없습니다)"),
    DIFFERENT_DIGIT_EXCEPTION("입력된 값은 서로 다른 3자리의 수여야 합니다."),
    END_OR_START_NUMBER_EXCEPTION("재시작/종료 입력값은 1과 2중 하나의 수여야 합니다.");


    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public static Message mappingHintMessage(int ballCount, int strikeCount) {
        if (ballCount == 1 && strikeCount == 0) {
            return Message.ONE_BALL;
        }
        if (ballCount == 1 && strikeCount == 1) {
            return Message.ONE_BALL_ONE_STRIKE;
        }
        if (ballCount == 2 && strikeCount == 0) {
            return Message.TWO_BALL;
        }
        if (ballCount == 2 && strikeCount == 1) {
            return Message.TWO_BALL_ONE_STRIKE;
        }
        if (ballCount == 3 && strikeCount == 0) {
            return Message.THREE_BALL;
        }
        if (ballCount == 0 && strikeCount == 1) {
            return Message.ONE_STRIKE;
        }
        if (ballCount == 0 && strikeCount == 2) {
            return Message.TWO_STRIKE;
        }
        if (ballCount == 0 && strikeCount == 3) {
            return Message.THREE_STRIKE;
        }
        if (ballCount == 0 && strikeCount == 0) {
            return Message.NOTHING;
        }

        throw new IllegalArgumentException("힌트 메시지에 오류가 발생하였습니다.");
    }
}
