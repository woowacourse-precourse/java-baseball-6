package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class Value {
    private List<Integer> numbers;

    public Value() {
        this.numbers = new ArrayList<>();
    }

    public Value(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Value makeValue(String num) {
        List<Integer> inputNum = new ArrayList<>();
        for (char digit : num.toCharArray()) {
            inputNum.add(Character.getNumericValue(digit));
        }
        return new Value(inputNum);
    }
}
