package baseball;

public class ResultMsgSelector {

    private static final String BALL_MSG = "볼";
    private static final String STRIKE_MSG = "스트라이크";
    private static final String NOTHING_MSG = "낫싱";
    private static final String THREE_STRIKES_MSG = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final int THREE_STRIKES = 3;

    public String selectResultMsg(int ballCount, int strikeCount) {
        StringBuilder resultMsg = new StringBuilder();

        if (ballCount > 0) {
            resultMsg.append(ballCount).append(BALL_MSG);
        }

        if (strikeCount > 0) {
            resultMsg.append(strikeCount).append(STRIKE_MSG);
        }

        if (ballCount == 0 && strikeCount == 0) {
            resultMsg.append(NOTHING_MSG);
        }

        if (strikeCount == THREE_STRIKES) {
            resultMsg.append("\n").append(THREE_STRIKES_MSG);
        }

        return resultMsg.toString();
    }
}
