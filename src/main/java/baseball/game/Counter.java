package baseball.game;

import baseball.type.CountSpeaker;

import java.util.ArrayList;
import java.util.List;

public class Counter {

    public int strikeBallCount(String guessNum, List<Integer> theAnswer) {
        int strikeCount = 0;
        int ballCount = 0;
        List<Integer> list = new ArrayList<>();
        int[] digits = new int[guessNum.length()];
        for (int i = 0; i < guessNum.length(); i++) {
            digits[i] = guessNum.charAt(i) - '0';
        }
        for (int num : digits) {
            list.add(num);
        }
        for (int i = 0; i < 3; i++) {
            if (list.contains(theAnswer.get(i))) {
                if (list.get(i) == theAnswer.get(i)) {
                    strikeCount++;
                } else {
                    ballCount++;
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
