package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerRandomNumbers {

    private static final int MAX_NUMBER_SIZE = 3;
    private static final int BEGIN_NUMBER = 1;
    private static final int END_NUMBER = 9;

    private final List<Integer> randomNumbers;

    // 컬렉션의 Wrapping을 생성자에서만 담당
    public ComputerRandomNumbers() {
        this.randomNumbers = generateRandomNumbers();
    }

    // 주어진 숫자 사이에서 중복을 허용하지 않고 MAX_NUMBER_SIZE 만큼 뽑음
    private List<Integer> generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < MAX_NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(BEGIN_NUMBER, END_NUMBER);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    public int get(int idx) {
        return randomNumbers.get(idx);
    }

    public int indexOf(int value) {
        return randomNumbers.indexOf(value);
    }

    public int size() {
        return randomNumbers.size();
    }

}
