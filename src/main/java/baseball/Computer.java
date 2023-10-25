package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer extends Number {

    public Computer() {
        super();
        generateNumbers();
    }

    public void generateNumbers() {
        this.nums = generate();
    }

    private List<Integer> generate() {
        List<Integer> nums = new ArrayList<>();
        while (nums.size() < COUNT) {
            int randomNumber = Randoms.pickNumberInRange(START, END);
            if (!nums.contains(randomNumber)) {
                nums.add(randomNumber);
            }
        }

        return nums;
    }

}
