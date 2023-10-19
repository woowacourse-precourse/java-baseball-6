package baseball;

public class Output {

    private static final String START = "숫자 야구 게임을 시작합니다.";
    private static final String ASK_NUMBER = "숫자를 입력해주세요 : ";
    private static final String NOTHING = "낫싱%n";
    private static final String BALL = "%d볼%n";
    private static final String STRIKE = "%d스트라이크%n";
    private static final String BALL_AND_STRIKE = "%d볼 %d스트라이크%n";
    private static final String CORRECT_AND_ASK_RESTART =
            "3개의 숫자를 모두 맞히셨습니다! 게임 종료%n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private int ball;
    private int strike;

    public Output(Judge judge) {
        this.ball = judge.getBall();
        this.strike = judge.getStrike();
    }
    public static void start() {
        System.out.println(START);
    }

    public void askNumber() {
        System.out.print(ASK_NUMBER);
    }

    public void printResult(JudgeStatus status) {
        printIfBall();
        printIfStrike();
        printIfBallAndStrike();
        printIfNothing(status);
        printIfCorrect(status);
    }

    private void printIfBall() {
        if (strike == 0) {
            System.out.printf(BALL, ball);
        }
    }

    private void printIfStrike() {
        if (ball == 0) {
            System.out.printf(STRIKE, strike);
        }
    }

    private void printIfBallAndStrike() {
        if (ball != 0 && strike != 0) {
            System.out.printf(BALL_AND_STRIKE, ball, strike);
        }
    }

    private void printIfCorrect(JudgeStatus status) {
        if (status.equals(JudgeStatus.CORRECT)) {
            System.out.println(CORRECT_AND_ASK_RESTART);
        }
    }

    private void printIfNothing(JudgeStatus status) {
        if (status.equals(JudgeStatus.NOTHING)) {
            System.out.println(NOTHING);
        }
    }
}
