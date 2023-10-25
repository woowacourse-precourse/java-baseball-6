package baseball;

import java.util.List;

public class RandomNums {
    int LENGTH = 3;
    List<Integer> randomNums;

    RandomNums(List<Integer> randomNums) {
        validateNums(randomNums);
        this.randomNums = randomNums;
    }

    private void validateNums(List<Integer> randomNums) {
        if (randomNums.size() != randomNums.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 값이 있습니다.");
        }
        if (randomNums.size() != LENGTH) {
            throw new IllegalArgumentException("숫자 개수가 맞지 않습니다");
        }
    }

    public List<Integer> getNums() {
        return randomNums;
    }
}
