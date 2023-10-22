package baseball.model.entity;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballNumber {
    private List<Integer> numbers;

    public BaseballNumber() {
        this.numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }
    public BaseballNumber(ArrayList<Integer> numbers) {
        this.numbers = numbers;
    }

    public BaseballNumber(String inputString) {
        List<Integer> inputNumbers = new ArrayList<>();
        try {
            for(char c : inputString.toCharArray()) {
                inputNumbers.add(Integer.parseInt(c + ""));
            }
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        if(inputNumbers.size() != 3) {
            throw new IllegalArgumentException();
        }
        this.numbers = inputNumbers;
    }
}
