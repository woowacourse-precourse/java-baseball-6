package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Numbers {

    private List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Numbers(String number) {
        this.numbers = changeStringToNumberList(number);
    }

    private List<Integer> changeStringToNumberList(String inputNumber) {
        numbers = new ArrayList<>();
        for (int i = 0; i < inputNumber.length(); i++) {
            numbers.add(Character.getNumericValue(inputNumber.charAt(i)));
        }
        return numbers;
    }

    public BallAndStrikeCount ballAndStrikeCount(Numbers playerNumbers) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < this.numbers.size(); i++) {
            if (playerNumbers.hasContainNumber(numbers.get(i), i)) ball += 1;
            if (playerNumbers.hasContainAndSamPositionNumber(numbers.get(i), i)) strike += 1;
        }
        return new BallAndStrikeCount(strike, ball);
    }

    public boolean hasContainNumber(int systemNumber, int position) {
        return numbers.contains(systemNumber) && numbers.indexOf(systemNumber) != position;
    }

    public boolean hasContainAndSamPositionNumber(int systemNumber, int position) {
        return this.numbers.indexOf(systemNumber) == position;
    }
}
