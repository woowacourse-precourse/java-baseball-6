package baseball.controller.game;

import baseball.type.CountSpeaker;

public class GameCounter {

    public static int hitBallCounter(String guessNum, String theAnswer) {
        int hitCount = 0;
        int ballCount = 0;
        for (int i = 0; i < theAnswer.length(); i++) {
            for (int j = 0; j < guessNum.length(); j++) {

                if (theAnswer.charAt(i) == guessNum.charAt(j)) {
                    if (i == j) {
                        hitCount++;
                    } else {
                        ballCount++;
                    }
                }
            }
        }
        countAnnouncer(hitCount, ballCount);
        return hitCount;
    }

    private static void countAnnouncer(int hitCount, int ballCount) {
        if (hitCount == 0 && ballCount == 0) {
            System.out.println(CountSpeaker.NOTHING.getCall());
        } else if (hitCount == 3) {
            System.out.println(hitCount + CountSpeaker.STRIKE.getCall());
        } else {
            if (hitCount == 0) {
                System.out.println(ballCount + CountSpeaker.BALL.getCall());
            } else if (ballCount == 0) {
                System.out.println(hitCount + CountSpeaker.STRIKE.getCall());
            } else {
                System.out.println(ballCount + CountSpeaker.BALL.getCall() + " " + hitCount + CountSpeaker.STRIKE.getCall());
            }
        }
    }
}
