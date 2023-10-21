package util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    private final int numberLength;
    private final int minNumber;
    private final int maxNumber;

    public NumberGenerator(int numberLength, int minNumber, int maxNumber) {

        this.numberLength = numberLength;
        this.minNumber = minNumber;
        this.maxNumber = maxNumber;
    }

    public List<Integer> generate() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < this.numberLength) {
            int randomNumber = Randoms.pickNumberInRange(this.minNumber, this.maxNumber);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }
}
