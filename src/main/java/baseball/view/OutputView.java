package baseball.view;

import baseball.domain.BallStatus;

public class OutputView {

    private static final int MIN_COUNT = 0;
    private static final int MAX_COUNT = 3;
    private static StringBuilder stringBuilder;

    private OutputView() {
    }

    public static void printHint(int[] board) {
        createStringBuilder();
        if (board[BallStatus.BALL.getValue()] > MIN_COUNT) {
            stringBuilder.append(board[BallStatus.BALL.getValue()]).append("볼").append(" ");
        }
        if (board[BallStatus.STRIKE.getValue()] > MIN_COUNT) {
            stringBuilder.append(board[BallStatus.STRIKE.getValue()]).append("스트라이크");
        }
        if (board[BallStatus.NOTHING.getValue()] > MAX_COUNT) {
            stringBuilder.append("낫싱");
        }
        System.out.println(stringBuilder);
    }

    public static void printEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private static void createStringBuilder() {
        stringBuilder = new StringBuilder();
    }
}
