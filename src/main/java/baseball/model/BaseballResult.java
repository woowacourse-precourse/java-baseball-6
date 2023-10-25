package baseball.model;

/**
 * 야구 게임의 결과를 나타내는 열거형입니다.
 *
 * <p>스트라이크, 볼, 낫싱의 세 가지 결과와 각 결과에 대한 메시지를 포함합니다.
 * 또한, 주어진 스트라이크와 볼의 수에 따라 결과 메시지를 반환하는 기능을 제공합니다.</p>
 */
public enum BaseballResult {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private final String message;

    /**
     * BaseballResult 열거형의 생성자입니다.
     *
     * @param message 각 결과에 해당하는 메시지
     */
    BaseballResult(String message) {
        this.message = message;
    }

    /**
     * 해당 결과의 메시지를 반환합니다.
     *
     * @return 결과 메시지
     */
    public String getMessage() {
        return message;
    }

    /**
     * 주어진 스트라이크와 볼의 개수에 따른 결과 메시지를 반환합니다.
     *
     * @param strikes 스트라이크의 개수
     * @param balls 볼의 개수
     * @return 주어진 스트라이크와 볼에 따른 결과 메시지
     */
    public static String getResultMessage(int strikes, int balls) {
        if (strikes > 0 && balls > 0) {
            return balls + BALL.message + " " + strikes + STRIKE.message;
        } else if (balls > 0) {
            return balls + BALL.message;
        } else if (strikes > 0) {
            return strikes + STRIKE.message;
        } else {
            return NOTHING.message;
        }
    }
}
