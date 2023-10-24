package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

/**
 * 랜덤한 숫자를 생성하고 관리
 */
public class RandomNumbers {
    private static final int NUMBER_LENGTH = 3;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 9;

    private final List<Integer> numbers = new ArrayList<>();

    public RandomNumbers() {
        generateRandomNumbers();
    }

    public void generateRandomNumbers() {
        while (numbers.size() < NUMBER_LENGTH) {
            int n = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
            validationAdd(n);
        }
    }

    public void validationAdd(Integer number) {
        if (!numbers.contains(number)) {
            numbers.add(number);     /* 중복된 숫자가 없는 경우 */
        }
    }

    public boolean contains(Integer number) {
        return numbers.contains(number);
    }

    public Integer getNumber(int index) {
        return numbers.get(index);
    }

    public List<Integer> getAllNumbers() {
        return new ArrayList<>(numbers);
    }

}
