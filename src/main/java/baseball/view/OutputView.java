package baseball.view;

import baseball.util.Messages;

public class OutputView {
    public void printGameStartMessage() {
        System.out.println(Messages.GAME_START_MESSAGE.getMessage());
    }

    public void printGameResultBallAndStrike(int ballCount, int strikeCount) {
        StringBuilder sb = new StringBuilder();
        if (ballCount != 0) {
            sb.append(ballCount).append(Messages.BALL_COUNT_MESSAGE.getMessage());
        }
        if (strikeCount != 0) {
            if (ballCount != 0) {
                sb.append(" ");
            }
            sb.append(strikeCount).append(Messages.STRIKE_COUNT_MESSAGE.getMessage());
        }
        if (ballCount == 0 && strikeCount == 0) {
            sb.append(Messages.NOTHING_MESSAGE.getMessage());
        }
        System.out.println(sb);
    }

    public void printGameEndMessage() {
        System.out.println(Messages.GAME_END_MESSAGE.getMessage());
    }
}
