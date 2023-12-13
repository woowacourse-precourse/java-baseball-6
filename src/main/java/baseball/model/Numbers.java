package baseball.model;

import static baseball.global.Constants.BASEBALL_SIZE;
import static baseball.global.Constants.END_NUM;
import static baseball.global.Constants.START_NUM;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Numbers {

    private final List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        validateSize(numbers);
        validateScope(numbers);
        validateDistinct(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }

    private void validateDistinct(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 존재합니다" + numbers);
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != BASEBALL_SIZE) {
            throw new IllegalArgumentException("[ERROR] BASEBALL SIZE와 다릅니다");
        }
    }

    private void validateScope(List<Integer> numbers) {
        boolean flag = numbers.stream()
                .allMatch(num -> START_NUM < num && num < END_NUM);
        if (!flag) {
            throw new IllegalArgumentException("[ERROR] 숫자 범위에 포함되지 않는 숫자가 있습니다 " + numbers);
        }
    }


    @Override
    public String toString() {
        return numbers.toString();
    }
}
