package baseball.model.entity;

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
            throw new IllegalArgumentException("서로 다른 3개의 숫자를 입력해주세요");
        }
        this.numbers = inputNumbers;
    }

    public List<BaseballNumber> getNumbers() {
        return numbers;
    }
}
