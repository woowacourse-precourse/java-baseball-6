package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import static baseball.domain.BaseballFlag.*;

public class ComputerNumbers {

    private final List<Integer> numbers;

    public ComputerNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<BaseballFlag> match(List<Integer> userNumbers) {
        List<BaseballFlag> matchResult = new ArrayList<>();
        for (int i = 0; i < userNumbers.size(); i++) {
            matchResult.add(strikeCheck(i, userNumbers.get(i)));
        }

        return matchResult;
    }

    private BaseballFlag ballCheck(int number) {
        if (numbers.contains(number)) {
            return BALL;
        }
        return NOTHING;
    }

    private BaseballFlag strikeCheck(int index, int number) {
        if (numbers.get(index) == number) {
            return STRIKE;
        }
        return ballCheck(number);
    }
}
