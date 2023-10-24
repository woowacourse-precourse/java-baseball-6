package baseball.common;

public enum Message {
    START("숫자 야구 게임을 시작합니다."),
    GET_BALL("숫자를 입력해주세요 : "),
    END(String.format("%d개의 숫자를 모두 맞히셨습니다! 게임 종료", Size.NUMBER.getValue())),
    RESTART(String.format("게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.",
            Command.RESTART.getKey(), Command.QUIT.getKey())),
    BALL("cond볼"),
    STRIKE("cond스트라이크"),
    NOTHING("낫싱");

    private String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public static String getScoreMessage(int ball, int strike) {
        if (ball > 0 && strike > 0) {
            return String.format("%s %s", BALL.convert(ball), STRIKE.convert(strike));
        }
        if (ball > 0) {
            return BALL.convert(ball);
        }
        if (strike > 0) {
            return STRIKE.convert(strike);
        }
        return NOTHING.message;
    }

    private String convert(int cond) {
        return message.replace("cond", Integer.toString(cond));
    }
}
