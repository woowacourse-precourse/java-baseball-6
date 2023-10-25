package baseball;

public class OutputHintChecker {
    private static final String STRING_BALL = "볼";
    private static final String STRING_STRIKE = "스트라이크";
    private static final String STRING_NOTHING = "낫싱";
    private static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static String getHint(int strike, int ball) {
        String hint = "";
        if (ball == 0 && strike == 0) {
            hint = STRING_NOTHING;
        } else if (ball == 0 && strike > 0) {
            if (strike == 3) {
                hint = strike + STRING_STRIKE + "\n" + GAME_END_MESSAGE;
            } else {
                hint = strike + STRING_STRIKE;
            }
        } else if (ball > 0 && strike == 0) {
            hint = ball + STRING_BALL;
        } else if (ball > 0 && strike > 0) {
            hint = ball + STRING_BALL + " " + strike + STRING_STRIKE;
        }
        return hint;
    }
}