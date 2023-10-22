package baseball.view;

import baseball.BallStatus;
import baseball.Message;
import baseball.model.ScoreBoard;

public class OutputView {
    public static void startGameMessage() {
        System.out.println(Message.STARTGAME_MESSAGE.getMessage());
    }

    public static void showScoreBoard(ScoreBoard scoreBoard) {
        StringBuilder stringBuilder = new StringBuilder();
        if (scoreBoard.isNothing()) {
            stringBuilder.append(BallStatus.NOTHING.getBallStatus());
        }
        if (scoreBoard.countBall() > 0) {
            stringBuilder.append(scoreBoard.countBall()).append(BallStatus.BALL.getBallStatus());
        }
        if (scoreBoard.countStrike() > 0) {
            stringBuilder.append(scoreBoard.countStrike()).append(BallStatus.STRIKE.getBallStatus());
        }
        System.out.println(stringBuilder);
    }

    public static void gameOverMessage() {
        System.out.println(Message.GAMEOVER_MESSAGE.getMessage());
    }
}

