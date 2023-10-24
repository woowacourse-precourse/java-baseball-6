package baseball.model.entity;

import baseball.exception.BaseballException.ListSizeException;
import java.util.ArrayList;
import java.util.List;

public class Baseball {
    private final List<BaseballNumber> numbers;

    public Baseball() {
        this.numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            BaseballNumber baseballNumber = new BaseballNumber();
            if (!numbers.contains(baseballNumber)) {
                numbers.add(baseballNumber);
            }
        }
    }

    public Baseball(String inputString) {
        List<BaseballNumber> inputNumbers = new ArrayList<>();
        for(char c : inputString.toCharArray()) {
            BaseballNumber number = new BaseballNumber(c);
            if(!inputNumbers.contains(number)) {
                inputNumbers.add(number);
            }
        }
        if(inputNumbers.size() != 3) {
            throw new ListSizeException();
        }
        this.numbers = inputNumbers;
    }

    public List<BaseballNumber> getNumbers() {
        return numbers;
    }


    public int countStrike(Baseball number) {
        if(number == null) {
            return 0;
        }
        Long strike = numbers.stream()
                .filter(n -> n.equals(number.getNumberByIndex(numbers.indexOf(n))))
                .count();
        return strike.intValue();
    }

    public int countBall(Baseball number) {
        if(number == null) {
            return 0;
        }
        Long ball = numbers.stream()
                .filter(n -> number.getNumbers().contains(n) && !number.getNumberByIndex(numbers.indexOf(n)).equals(n))
                .count();
        return ball.intValue();
    }

    public BaseballNumber getNumberByIndex(int index) {
        return numbers.get(index);
    }
}
