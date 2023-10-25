package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputException {
    
    public void checkInputExection(List<Integer> numbers) {

        overLengthNumber(numbers);
        outOfRangeNumber(numbers);
        duplicatedNumber(numbers);

    }


    public void overLengthNumber(List<Integer> numbers) {
        if (numbers.size() != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력하세요");
        }
    }

    public void outOfRangeNumber(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) < 1 || numbers.get(i) > 9) {
                throw new IllegalArgumentException("1~9 사이의 숫자를 입력하세요.");

            }
        }
    }

    public void duplicatedNumber(List<Integer> numbers) {

        Set<Integer> setNumbers = new HashSet<>(numbers);
        if (numbers.size() != setNumbers.size()) {
            throw new IllegalArgumentException("3자리 숫자를 입력하세요");

        }
    }
}
