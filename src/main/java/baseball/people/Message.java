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

    /**
     * 각각의 객체에 지정된 문자열을 반환하는 메서드
     */
    public String getMessage() {
        return message;
    }

    /**
     * 볼 개수와 스트라이크 개수에 각각 문자열을 추가해서 반환한다. 단, 0개이면 문자열에 추가하지 않는다.
     *
     * @param ball   볼 개수
     * @param strike 스트라이크 개수
     */
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
