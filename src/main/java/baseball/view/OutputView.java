package baseball.view;

public class OutputView {
    private static final String OUTPUT_START_PROGRAM = "숫자 야구 게임을 시작합니다.";
    private static final String OUTPUT_NOTHING = "낫싱";
    private static final String OUTPUT_ONLY_BALL = "%d볼\n";
    private static final String OUTPUT_ONLY_STRIKE = "%d스트라이크\n";
    private static final String OUTPUT_BALL_STRIKE = "%d볼 %d스트라이크\n";
    private static final String OUTPUT_END_PROGRAM = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void outputStartProgram() {
        System.out.println(OUTPUT_START_PROGRAM);
    }

    public void outputNothing() {
        System.out.println(OUTPUT_NOTHING);
    }

    public void outputOnlyBall(int ball) {
        System.out.printf(OUTPUT_ONLY_BALL, ball);
    }

    public void outputOnlyStrike(int strike) {
        System.out.printf(OUTPUT_ONLY_STRIKE, strike);
    }

    public void outputBallStrike(int ball, int strike) {
        System.out.printf(OUTPUT_BALL_STRIKE, ball, strike);
    }

    public void outputEndProgram() {
        System.out.println(OUTPUT_END_PROGRAM);
    }
}
