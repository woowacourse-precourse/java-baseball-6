package baseball.domain;

import static baseball.global.constant.BaseballConstant.PLAY_AMOUNT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Integer> numbers;

    private Computer(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Computer generate() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < PLAY_AMOUNT) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return new Computer(numbers);
    }

    public int getNumberOf(int index) {
        return numbers.get(index);
    }

    public boolean contains(int number) {
        return this.numbers.contains(number);
    }

}
