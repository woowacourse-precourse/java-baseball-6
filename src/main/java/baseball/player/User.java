package baseball.player;

import baseball.data.BaseballNumbers;
import baseball.data.GameResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User implements Player{
    private BaseballNumbers baseBallNumbers;

    public User() {
    }

    @Override
    public BaseballNumbers generateBallNumber(List<Integer> numbers) throws IllegalArgumentException {
        return new BaseballNumbers(numbers);
    }

    @Override
    public BaseballNumbers ask() {
        return baseBallNumbers;
    }

    @Override
    public GameResult reply(BaseballNumbers otherBaseballNumbers) {
        return baseBallNumbers.getResult(otherBaseballNumbers);
    }


    public void inputNumbers(int number) {
        List<Integer> numbers = parseNumber(number);
        baseBallNumbers = generateBallNumber(numbers);
    }

    private List<Integer> parseNumber(int number) {
        List<Integer> numbers = new ArrayList<>();

        while (number > 0) {
            numbers.add(number % 10);
            number /= 10;
        }
        Collections.reverse(numbers);

        return numbers;
    }
}
