package baseball.play;

import baseball.domain.Count;
import baseball.utils.RandomNumber;

import java.util.Collections;
import java.util.List;

/**
 * 카운트 계산
 */
public class BallCount {

    private static List<Integer> answer;

    public BallCount() {
        answer = RandomNumber.generateRandomNumber();
    }

    public void checkCount(List<Integer> input, Count count) {
        int strike = countStrike(input);
        int ball = countBall(input) - strike;
        count.setCount(ball, strike);
    }

    public int countBall(List<Integer> input) {
        int ball = 0;
        for (int i = 0; i < input.size(); i++) {
            ball += countNumberFrequency(input, answer.get(i));
        }
        return ball;
    }

    private int countNumberFrequency(List<Integer> input, int answer) {
        return Collections.frequency(input, answer);
    }

    public int countStrike(List<Integer> input) {
        int strike = 0;
        for (int i = 0; i < input.size(); i++) {
            strike += countSamePositionNumber(input.get(i), answer.get(i));
        }
        return strike;
    }

    private int countSamePositionNumber(int input, int answer) {
        if (input == answer) {
            return 1;
        }
        return 0;
    }
}
