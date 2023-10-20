package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumber {
    private final List<Integer> numbers;

    private ComputerNumber() {
        this.numbers = generateNumbers();
    }

    public static ComputerNumber createComputerNumber () {
        return new ComputerNumber();
    }

    /**
     * 1 ~ 9 의 서로 다른 숫자 3개 생성
     */
    private List<Integer> generateNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() != 3) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }
        return numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
