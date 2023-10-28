package baseball.domain;

import static baseball.util.NumberUtil.convertListToString;
import static baseball.util.NumberUtil.validate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {

    private final List<Integer> numberList;

    public Player(List<Integer> numbers) {
        validate(convertListToString(numbers));
        this.numberList = new ArrayList<>(numbers);
    }

    public List<Integer> getNumberList() {
        return Collections.unmodifiableList(numberList);
    }
}
