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
        for(char c : inputString.toCharArray()) {
            int number = validateNumber(c);
            if(!inputNumbers.contains(number)) {
                inputNumbers.add(number);
            }
        }
        if(inputNumbers.size() != 3) {
            throw new IllegalArgumentException("서로 다른 3개의 숫자를 입력해주세요");
        }
        this.numbers = inputNumbers;
    }

    private int validateNumber(char c ) {
        int number;
        try {
            number = Integer.parseInt(String.valueOf(c));
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
        if(number < 1 || number > 9) {
            throw new IllegalArgumentException("1~9 사이의 숫자를 입력해주세요");
        }
        return number;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
