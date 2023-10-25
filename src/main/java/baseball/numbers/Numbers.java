package baseball.numbers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.constant.Error.*;
import static baseball.constant.Rule.*;

/*
    일급 컬렉션 사용해보기
 */

public class Numbers {

    private final List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        checkValidNumbers(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers.stream().toList();
    }

    private void checkValidNumbers(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);

        if (numberSet.size() != SIZE.getValue())
            throw new IllegalArgumentException(NUMBERS_SIZE.getMessage());

        for (Integer number : numbers) {
            if (number < START.getValue() || number > END.getValue())
                throw new IllegalArgumentException();
        }
    }

}
