package baseball.controller;

import static baseball.model.GameNumbers.GAME_NUMBERS_SIZE;

import baseball.model.GameNumbers;
import baseball.model.Score;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class ScoreCalculator {
    public Score calculateScore(GameNumbers playerNumbers, GameNumbers answer) {
        Set<Integer> intersection = getIntersection(playerNumbers, answer);
        int strikeCount = countStrike(playerNumbers, answer);
        int ballCount = intersection.size() - strikeCount;

        return new Score(ballCount, strikeCount);
    }

    private Set<Integer> getIntersection(GameNumbers playerNumbers, GameNumbers answer) {
        Set<Integer> playerSet = new HashSet<>();
        Set<Integer> answerSet = new HashSet<>();
        for (int i = 0; i < GAME_NUMBERS_SIZE; i++) {
            playerSet.add(playerNumbers.get(i));
            answerSet.add(answer.get(i));
        }
        playerSet.retainAll(answerSet);
        return playerSet;
    }

    private int countStrike(GameNumbers playerNumbers, GameNumbers answer) {
        int strikeCount = (int) IntStream.range(0, GAME_NUMBERS_SIZE)
                .filter(i -> playerNumbers.isEqualToAt(i, answer.get(i)))
                .count();
        return strikeCount;
    }

}
