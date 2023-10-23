package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> numbers;

    public Computer() {
        this.numbers = generateRamdomNumber();
    }

    private List<Integer> generateRamdomNumber() {  // 랜덤 숫자 생성
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    public List<Integer> getNumbers() { // 랜덤 숫자 접근
        return this.numbers;
    }
}
