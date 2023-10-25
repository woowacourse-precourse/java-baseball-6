package baseball.game;

import baseball.domain.Result;

import java.util.List;

public class Counter {

    public int countStrikeBall(String guessNum, List<Integer> theAnswer) {
        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < theAnswer.size(); i++) {
            int answerDigit = theAnswer.get(i);
            int guessDigit = toInt(guessNum.charAt(i));
            if (isStrike(answerDigit, guessDigit)) {
                strikeCount++;
                continue;
            }
            if (isBall(theAnswer, guessDigit)) {
                ballCount++;
            }
        }
        Result.of(strikeCount, ballCount).indicator();
        return strikeCount;
    }

    private int toInt(char input) {
        return input - '0';
    }
    private boolean isStrike(int answerDigit, int guessDigit) {
        return answerDigit == guessDigit;
    }
    private boolean isBall(List<Integer> theAnswer, int guessDigit) {
        return theAnswer.contains(guessDigit);
    }

}
