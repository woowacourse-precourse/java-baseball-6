package baseball.game;

import baseball.type.CountSpeaker;

public class Counter {

    public int strikeBallCount(String guessNum, String theAnswer) {
        int strikeCount = 0;
        int ballCount = 0;
        for (int i = 0; i < theAnswer.length(); i++) {
            for (int j = 0; j < guessNum.length(); j++) {

                if (theAnswer.charAt(i) == guessNum.charAt(j)) {
                    if (i == j) {
                        strikeCount++;
                    } else {
                        ballCount++;
                    }
                }
            }
        }
        indicator(strikeCount, ballCount);
        return strikeCount;
    }

    private void indicator(int strikeCount, int ballCount) {
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
