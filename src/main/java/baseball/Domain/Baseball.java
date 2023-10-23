package baseball.Domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Baseball {

    private List<Integer> numbers;

    public Baseball(List<Integer> numbers) {
        build(numbers);
    }

    private void build(List<Integer> numbers) {
        validateSize(numbers);
        validateZero(numbers);
        this.numbers = numbers;
    }

    private static void validateZero(List<Integer> numbers) {
        for(Integer n : numbers) if(n == 0) throw new IllegalArgumentException();
    }

    private static void validateSize(List<Integer> numbers) {
        if(numbers.size() != 3) throw new IllegalArgumentException();
    }

    public BaseballScore compare(Baseball baseball) {
        int ball = countBall(baseball);
        int strike = countStrike(baseball);
        return new BaseballScore(ball, strike);
    }

    private int countBall(Baseball baseball) {
        int cnt = 0;
        for(int i = 0; i < 3; i++) {
            if(baseball.isBall(numbers.get(i), i)) cnt++;
        }
        return cnt;
    }

    private int countStrike(Baseball baseball) {
        int cnt = 0;
        for(int i = 0; i < 3; i++) {
            if(baseball.isStrike(numbers.get(i), i)) cnt++;
        }
        return cnt;
    }

    private boolean contains(int number) {
        return numbers.contains(number);
    }

    private boolean isStrike(int number, int index) {
        return numbers.indexOf(number) == index;
    }

    private boolean isBall(int number, int index) {
        return numbers.indexOf(number) != index;
    }

}
