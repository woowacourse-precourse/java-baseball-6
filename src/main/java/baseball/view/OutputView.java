package baseball.view;

import baseball.domain.BallCounter;

public class OutputView {
    private static final int ZERO = 0;
    private static final String STRIKE = "스트라이크 ";
    private static final String BALL = "볼 ";
    private static final String NOTHING = "낫싱 ";
    private StringBuilder stringBuilder;

    public void showResult(BallCounter ballCounter) {
        stringBuilder = new StringBuilder();

        checkBallCount(ballCounter);
        checkStrikeCount(ballCounter);
        checkNothing(ballCounter);
        System.out.println(stringBuilder);
    }

    private void checkStrikeCount(BallCounter ballCounter) {
        if (ballCounter.getStrikeCount() != ZERO) {
            stringBuilder.append(ballCounter.getStrikeCount()).append(STRIKE);
        }
    }

    private void checkBallCount(BallCounter ballCounter) {
        if (ballCounter.getBallCount() != ZERO) {
            stringBuilder.append(ballCounter.getBallCount()).append(BALL);
        }
    }

    private void checkNothing(BallCounter ballCounter) {
        if (ballCounter.isNothing()) {
            stringBuilder.append(NOTHING);
        }
    }

    public void showGameEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
