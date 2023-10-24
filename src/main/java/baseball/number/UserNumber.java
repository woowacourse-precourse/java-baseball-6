package baseball.number;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class UserNumber extends Number {

    public UserNumber() {
        super.numbers = makeNumbers();
    }

    public List<Integer> makeNumbers() {
        System.out.print("숫자를 입력해주세요 : ");

        int inputNumbers = 0;
        try {
            inputNumbers = Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("정수를 입력해주세요.");
        }

        if ((inputNumbers < 100) || (inputNumbers > 999)) {
            throw new IllegalArgumentException("3자리 수를 입력해주세요.");
        }

        List<Integer> numbers = new ArrayList<>();
        int digit = 100;
        while (numbers.size() < 3) {
            int number = inputNumbers / digit;

            if ((number < 1) || (number > 9)) {
                throw new IllegalArgumentException("1부터 9까지 수를 입력해주세요.");
            }

            if (numbers.contains(number)) {
                throw new IllegalArgumentException("중복되지 않은 숫자를 입력해주세요.");
            }

            numbers.add(number);

            inputNumbers %= digit;
            digit /= 10;
        }

        return numbers;
    }
}
