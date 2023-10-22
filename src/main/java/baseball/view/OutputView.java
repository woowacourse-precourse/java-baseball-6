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

    public void outputOnlyBall(int n) {
        System.out.printf(OUTPUT_ONLY_BALL, n);
    }

    public void outputOnlyStrike(int n) {
        System.out.printf(OUTPUT_ONLY_STRIKE, n);
    }

    public void setOutputBallStrike(int[] n) {
        System.out.printf(OUTPUT_BALL_STRIKE, n[0], n[1]);
    }

    public void outputEndProgram() {
        System.out.println(OUTPUT_END_PROGRAM);
    }
}
