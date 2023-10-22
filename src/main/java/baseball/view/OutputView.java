package baseball.view;

import baseball.Message;
import baseball.model.ScoreBoard;

public class OutputView {
    public static void startGameMessage() {
        System.out.println(Message.STARTGAMEMESSAGE.getMessage());
    }

    public static void showScoreBoard(ScoreBoard scoreBoard) {
        StringBuilder stringBuilder = new StringBuilder();
        if (scoreBoard.isNothing()) {
            stringBuilder.append("낫싱");
        }
        if (scoreBoard.countBall() > 0) {
            stringBuilder.append(scoreBoard.countBall()).append("볼 ");
        }
        if (scoreBoard.countStrike() > 0) {
            stringBuilder.append(scoreBoard.countStrike()).append("스트라이크");
        }
        System.out.println(stringBuilder);
    }

    public static void gameOverMessage() {
        System.out.println(Message.GAMEOVERMESSAGE.getMessage());
    }
}

