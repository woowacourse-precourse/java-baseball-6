package baseball.view;

import baseball.model.Score;

public class Result {
    private static final String BALL_MESSAGE = "볼";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String NOTHING_MESSAGE = "낫싱";

    private String scoreMessage = "";

    Score score;


    public Result(Score score) {
        this.score = score;
    }

    public void printMessages() {
        makeScoreMessage();
        System.out.println(scoreMessage);
    }

    private void makeScoreMessage() {
        addBallMessage();
        addStrikeMessage();
        addNothingMessage();
    }

    private void addBallMessage() {
        if (score.getBall() > 0) {
            scoreMessage += score.getBall() + BALL_MESSAGE;
        }
    }

    private void addStrikeMessage() {
        if (score.getStrike() > 0) {
            scoreMessage += score.getStrike() + STRIKE_MESSAGE;
        }
    }

    private void addNothingMessage() {
        if (score.isNothing()) {
            scoreMessage = NOTHING_MESSAGE;
        }
    }

}
