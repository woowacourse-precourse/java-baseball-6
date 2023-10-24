package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GetNumbers {
    private static final int MAX_NUM_LENGTH = 3;
    public List<Integer> getRandomNumber() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public List<Integer> getUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        List<Integer> numbers = new ArrayList<>();

        for (char ch : input.toCharArray()) {
            int numberValue = Character.getNumericValue(ch);

            if (notContainNumber(numbers, numberValue)) {
                throw new IllegalArgumentException("중복된 값은 입력불가합니다.");
            }

            if (!notNumberRange(numberValue, 1, 9)) {
                throw new IllegalArgumentException("1~9 사이의 정수만 입력가능합니다.");
            }

            numbers.add(numberValue);
        }

        if (notListSize(numbers, MAX_NUM_LENGTH)) {
            throw new IllegalArgumentException("세자리 수만 입력가능합니다.");
        }

        return numbers;
    }

    public boolean notContainNumber(List<Integer> list, int value) {
        return list.contains(value);
    }

    public boolean notNumberRange(int value, int min, int max) {
        return value >= min && value <= max;
    }

    public boolean notListSize(List<Integer> list, int size) {
        return list.size() != size;
    }
}
