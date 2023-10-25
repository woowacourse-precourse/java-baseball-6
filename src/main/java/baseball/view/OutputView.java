package baseball.view;

import baseball.domain.BallStatus;
import baseball.domain.Board;

public class OutputView {

    private static final int ZERO_COUNT = 0;
    private static final int MAX_COUNT = 3;

    private OutputView() {
    }

    public static void printStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printHint(Board board) {
        String hint = makeHint(board);
        System.out.println(hint);
    }

    public static void printEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private static String makeHint(Board board) {
        StringBuilder stringBuilder = new StringBuilder();

        if (board.getScore(BallStatus.BALL) > ZERO_COUNT) {
            stringBuilder.append(board.getScore(BallStatus.BALL)).append("볼 ");
        }
        if (board.getScore(BallStatus.STRIKE) > ZERO_COUNT) {
            stringBuilder.append(board.getScore(BallStatus.STRIKE)).append("스트라이크");
        }
        if (board.getScore(BallStatus.NOTHING) == MAX_COUNT) {
            stringBuilder.append("낫싱");
        }

        return stringBuilder.toString();
    }
}
