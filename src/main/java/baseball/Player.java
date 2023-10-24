package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Integer> numList;
    private String numbers;
    private int number;

    public List<Integer> inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        numList = new ArrayList<>();
        numbers = Console.readLine();
        isSuitableNumber(numbers);
        for (int i = 0; i < numbers.length(); i++) {
            number = numbers.charAt(i) - '0';
            isSuitableNumber(number);
            if (!numList.contains(number)) {
                numList.add(number);
            }
        }
        isSuitableNumber(numList);
        return numList;
    }

    private void isSuitableNumber(String numbers) {
        if (numbers.length() != 3) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    private void isSuitableNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    private void isSuitableNumber(List<Integer> numList) {
        if (numList.size() < 3) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }
}
