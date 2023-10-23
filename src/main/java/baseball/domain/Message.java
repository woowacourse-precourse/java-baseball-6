package baseball.domain;

public enum Message {

    START("숫자 야구 게임을 시작합니다."),
    INPUT("숫자를 입력해주세요 : "),
    END_OR_START("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    NOTHING("낫싱"),
    ONE_BALL("1볼"),
    ONE_BALL_ONE_STRIKE("1볼 1스트라이크"),
    TWO_BALL("2볼"),
    TWO_BALL_ONE_STRIKE("2볼 1스트라이크"),
    THREE_BALL("3볼"),
    ONE_STRIKE("1스트라이크"),
    TWO_STRIKE("2스트라이크"),
    THREE_STRIKE("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");

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
