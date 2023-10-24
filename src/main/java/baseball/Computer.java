package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

class Computer {
    private static final int MIN_NUMBER = 1; // 생성할 수 있는 최소 숫자 초기화
    private static final int MAX_NUMBER = 9; // 생성할 수 있는 최대 숫자 초기화
    private final int numberOfDigits;

    public Computer(int numberOfDigits) {
        this.numberOfDigits = numberOfDigits;
    }

    public List<Integer> generateNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < numberOfDigits) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }
}


