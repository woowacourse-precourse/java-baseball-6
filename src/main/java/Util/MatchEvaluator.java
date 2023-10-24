package Util;

import baseball.BallCount;
import java.util.stream.IntStream;

public class MatchEvaluator {

    public BallCount evaluate(int[] guessArray, int[] computerNumbers) {
        int strikes = (int) IntStream.range(0, guessArray.length)
                .filter(i -> guessArray[i] == computerNumbers[i])
                .count();

        int balls = (int) IntStream.range(0, guessArray.length)
                .filter(i -> guessArray[i] != computerNumbers[i] && contains(computerNumbers, guessArray[i]))
                .count();

        return new BallCount(strikes, balls);
    }

    private boolean contains(int[] array, int num) {
        return IntStream.of(array).anyMatch(i -> i == num);
    }
}
