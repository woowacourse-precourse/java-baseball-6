package baseball;

public class Output {

    private static final String START = "숫자 야구 게임을 시작합니다.";
    private static final String ASK_NUMBER = "숫자를 입력해주세요 : ";
    private static final String NOTHING = "낫싱%n";
    private static final String BALL = "%d볼%n";
    private static final String STRIKE = "%d스트라이크%n";
    private static final String BALL_AND_STRIKE = "%d볼 %d스트라이크%n";
    private static final String CORRECT_AND_ASK_RESTART =
            "3개의 숫자를 모두 맞히셨습니다! 게임 종료%n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.%n";

    public static void start() {
        System.out.println(START);
    }

    public void askNumber() {
        System.out.print(ASK_NUMBER);
    }

    public void printResult(JudgeResult result) {
        if (isNothing(result)) {
            System.out.printf(NOTHING);
            return;
        }
        printBallAndStrike(result.getBall(), result.getStrike());
        if (isCorrect(result)) {
            System.out.printf(CORRECT_AND_ASK_RESTART);
        }
    }

    private boolean isNothing(JudgeResult result) {
        return result.getStatus() == JudgeStatus.NOTHING;
    }

    private boolean isCorrect(JudgeResult result) {
        return result.getStatus() == JudgeStatus.CORRECT;
    }

    private void printBallAndStrike(int ball, int strike) {
        if (ball != 0 && strike == 0) {
            System.out.printf(BALL, ball);
        }
        if (ball == 0 && strike != 0) {
            System.out.printf(STRIKE, strike);
        }
        if (ball != 0 && strike != 0) {
            System.out.printf(BALL_AND_STRIKE, ball, strike);
        }
    }
}
