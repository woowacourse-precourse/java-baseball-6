package baseball;

import baseball.domain.Count;

import java.util.Collections;
import java.util.List;

/**
 * 카운트 동작
 */
public class CountCheck {

    private static List<Integer> answer;

    public CountCheck() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        answer = randomNumberGenerator.generate();
    }

    /**
     * 테스트용 getter
     */
    public List<Integer> getAnswer() {
        return answer;
    }

    public Count checkCount(List<Integer> input, Count count) {
        int strike = countStrike(input);
        int ball = countBall(input) - strike;
        count.setBallCount(ball);
        count.setStrikeCount(strike);
        return count;
    }

    public int countBall(List<Integer> input) {
        int ball = 0;
        for (int i = 0; i < input.size(); i++) {
            ball += countSameNumber(input, answer.get(i));
        }
        return ball;
    }

    private int countSameNumber(List<Integer> input, int compare) {
        return Collections.frequency(input, compare);
    }

    public int countStrike(List<Integer> number) {
        int strike = 0;

        for (int i = 0; i < number.size(); i++) {
            strike += countSameLocationNumber(number.get(i), answer.get(i));
        }
        return strike;
    }

    private int countSameLocationNumber(int number, int computer) {
        if (number == computer) {
            return 1;
        }
        return 0;
    }
}
