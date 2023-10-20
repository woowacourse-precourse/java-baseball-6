package baseball.view;

import baseball.domain.BallCounter;

public class OutputView {
    private StringBuilder stringBuilder;

    public void showResult(BallCounter ballCounter) {
        stringBuilder = new StringBuilder();

        checkStrikeCount(ballCounter);
        checkBallCount(ballCounter);
        checkNothing(ballCounter);
        System.out.println(stringBuilder);
    }

    private void checkStrikeCount(BallCounter ballCounter) {
        if (ballCounter.getStrikeCount() != 0) {
            stringBuilder.append(ballCounter.getStrikeCount()).append("스트라이크");
        }
    }

    private void checkBallCount(BallCounter ballCounter) {
        if (ballCounter.getBallCount() != 0) {
            stringBuilder.append(ballCounter.getBallCount()).append("볼");
        }
    }

    private void checkNothing(BallCounter ballCounter) {
        if (ballCounter.isNothing()) {
            stringBuilder.append("낫싱");
        }
    }

    public void showGameEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
