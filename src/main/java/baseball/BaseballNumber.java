package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumber {

    private final List<Integer> numbers;

    private BaseballNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }
    // 데이터 변경을 막기 위해 new list 반환
    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    // 유효성 검사 후 숫자 담은 객체 생성
    public static BaseballNumber from(String input) {
        if (!InputValidator.isValidInput(input)) {
            throw new IllegalArgumentException("잘못된 입력입니다. " +
                    "입력은 서로 다른 3자리 숫자이어야 합니다.");
        }
        return new BaseballNumber(parseInput(input));
    }
    // random 숫자 생성 (모두 다른 3자리 숫자)
    public static BaseballNumber generateRandom() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return new BaseballNumber(randomNumbers);
    }
    // input: String -> 3개의 원소 가진 ArrayList
    private static List<Integer> parseInput(String input) {
        List<Integer> result = new ArrayList<>();
        for (char ch : input.toCharArray()) {
            result.add(Character.getNumericValue(ch));
        }
        return result;
    }
}
