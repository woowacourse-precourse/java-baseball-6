package baseball.people;

public enum Message {
    GAME_START("숫자 야구 게임을 시작합니다."),
    GAME_END("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    BALL("%d볼"),
    STRIKE("%d스트라이크"),
    BALL_STRIKE("%d볼 %d스트라이크"),
    NOTHING("낫싱"),
    DEMAND_INPUT("숫자를 입력해주세요 : "),
    ASK_TO_RESTART("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. "),
    RESTART("1"),
    QUIT("2");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public static String getBallStrikeMessage(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            return NOTHING.message;
        }

        if (ball == 0) {
            return String.format(STRIKE.message, strike);
        }

        if (strike == 0) {
            return String.format(BALL.message, ball);
        }

        return String.format(BALL_STRIKE.message, ball, strike);
    }
}
