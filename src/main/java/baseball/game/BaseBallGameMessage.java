package baseball.game;

public class BaseBallGameMessage {
    public static final String GAME_START = "숫자 야구 게임을 시작합니다.";
    public static final String INPUT_NUMBER = "숫자를 입력해주세요 : ";
    public static final String GAME_OVER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String BALL = "볼 ";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";


    public static String makeResultString(int strike, int ball) {

        return makeBallString(ball)
                + makeStrikeString(strike)
                + makeNothingString(strike, ball);
    }

    private static String makeBallString(int ball) {

        if (ball != 0) {
            return ball + BALL;
        }
        return "";
    }

    private static String makeStrikeString(int strike) {

        if (strike != 0) {
            return strike + STRIKE;
        }
        return "";
    }

    private static String makeNothingString(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            return NOTHING;
        }
        return "";
    }
}
