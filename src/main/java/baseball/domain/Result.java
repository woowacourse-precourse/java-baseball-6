package baseball.domain;

import baseball.type.CountSpeaker;

public class Result {

    private int strikeCount;
    private int ballCount;

    private void setStrikeCount(int strikeCount) {
        this.strikeCount = strikeCount;
    }

    private void setBallCount(int ballCount) {
        this.ballCount = ballCount;
    }

    public static Result of(int strikeCount, int ballCount) {
        Result result = new Result();
        result.setStrikeCount(strikeCount);
        result.setBallCount(ballCount);
        return result;
    }

    public void indicator() {
        if (strikeCount == 0 && ballCount == 0) {
            System.out.println(CountSpeaker.NOTHING.getCall());
        } else if (strikeCount == 3) {
            System.out.println(strikeCount + CountSpeaker.STRIKE.getCall());
        } else {
            if (strikeCount == 0) {
                System.out.println(ballCount + CountSpeaker.BALL.getCall());
            } else if (ballCount == 0) {
                System.out.println(strikeCount + CountSpeaker.STRIKE.getCall());
            } else {
                System.out.println(ballCount + CountSpeaker.BALL.getCall() + " " + strikeCount + CountSpeaker.STRIKE.getCall());
            }
        }
    }
}
