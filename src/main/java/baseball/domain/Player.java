package baseball.domain;

import static baseball.util.NumberUtil.convertListToString;
import static baseball.util.NumberUtil.validate;

import java.util.List;

public class Player {

    private List<Integer> numberList;

    public Player(List<Integer> numbers) {
        validate(convertListToString(numbers));
        this.numberList = numbers;
    }

    public List<Integer> getNumberList() {
        return numberList;
    }
}
