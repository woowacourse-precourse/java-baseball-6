package baseball;

public class GameResultPrinter {
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    String STRING_BALL = "볼";
    String STRING_STRIKE = "스트라이크";
    String STRING_NOTHING = "낫싱";

    public void printStartGame() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void printEndGame() {
        System.out.println(GAME_END_MESSAGE);
    }

    public void printResult(int strike, int ball) {
        String result = "";
        if (ball == 0 && strike == 0) {
            result = STRING_NOTHING;
        } else if (ball == 0 && strike > 0) {
            if (strike == 3) {
                result = GAME_END_MESSAGE;
            } else {
                result = strike + STRING_STRIKE;
            }
        } else if (ball > 0 && strike == 0) {
            result = ball + STRING_BALL;
        } else if (ball > 0 && strike > 0) {
            result = ball + STRING_BALL + " " + strike + STRING_STRIKE;
        }
        System.out.println(result);
    }



}
