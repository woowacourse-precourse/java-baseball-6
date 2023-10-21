package baseball;

public class BaseBallUI {
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String PLAYING_MESSAGE = "숫자를 입력해주세요 : ";

    private static final String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String NOBALL_NOSTRIKE_MESSAGE = "낫싱";

    private static final String STRIKE_MESSAGE = "%d스트라이크";
    private static final String BALL_MESSAGE = "%d볼";

    void startGame() {
        System.out.println(START_MESSAGE);
    }

    void playing() {
        System.out.println(PLAYING_MESSAGE);
    }

    void printBaseBallScore(BaseBallScore baseBallScore) {
        String baseBallScoreMessage = getBaseBallScoreMessage(baseBallScore);
        System.out.println(baseBallScoreMessage);
    }

    private String getBaseBallScoreMessage(BaseBallScore baseBallScore) {
        if (baseBallScore.getBall() == 0 && baseBallScore.getStrike() == 0)
            return NOBALL_NOSTRIKE_MESSAGE;
        return nBallmStrikeMessage(baseBallScore);
    }

    private String nBallmStrikeMessage(BaseBallScore baseBallScore) {
        String message = "";
        if (baseBallScore.getBall() > 0)
            message += String.format(BALL_MESSAGE, baseBallScore.getBall());
        message += " ";
        if (baseBallScore.getStrike() > 0)
            message += String.format(STRIKE_MESSAGE, baseBallScore.getStrike());
        message = message.trim();
        return message;
    }

    void endGame() {
        System.out.println(END_MESSAGE);
    }
}
