package baseball.model;

import java.util.ArrayList;
import java.util.List;

import baseball.constant.Constant;
import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private List<Integer> numbers = new ArrayList<>();

    public Computer() {
    }

    public void generateRandomNumbers() {
        init();
        while (numbers.size() < Constant.MAX_DIGIT) {
            int randomNumber = Randoms.pickNumberInRange(Constant.MIN_NUMBER, Constant.MAX_NUMBER);
            if (!numbers.contains(randomNumber))
                numbers.add(randomNumber);
        }
    }
    
    public void init() {
        numbers.clear();
    }
    
    public List<Integer> getNumbers() {
        return numbers;
    }
}
