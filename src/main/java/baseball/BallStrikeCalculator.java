package baseball;

import static baseball.ConstValue.BASEBALL_MAX_LENGTH;

import java.util.Arrays;
import java.util.stream.IntStream;

public class BallStrikeCalculator {

    // 스트라이크와 볼 갯수를 Score 객체로 반환
    public Score countStrikeAndBallToScore(int[] userAnswer, int[] computerAnswer) {
        int strikes = countStrike(userAnswer, computerAnswer);
        int balls = countBall(userAnswer, computerAnswer);

        return new Score(strikes, balls);
    }

    // 스트라이크 숫자 갯수 반환
    public int countStrike(int[] userAnswer, int[] computerAnswer) {
        return (int) IntStream.range(0, BASEBALL_MAX_LENGTH)
                .filter(i -> userAnswer[i] == computerAnswer[i])
                .count();
    }

    // 볼 숫자 갯수 반환
    public int countBall(int[] userAnswer, int[] computerAnswer) {
        return (int) IntStream.range(0, BASEBALL_MAX_LENGTH)
                .filter(i -> userAnswer[i] != computerAnswer[i])
                .filter(i -> Arrays.stream(computerAnswer).anyMatch(x -> x == userAnswer[i]))
                .count();
    }
}
