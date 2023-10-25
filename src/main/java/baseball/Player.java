package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Player {

    public List<Integer> generateNumbers() {
        List<Integer> numbers = new ArrayList<>();

        System.out.print("숫자를 입력해주세요 :");
        String input = Console.readLine();

        if (input.length() != 3) {
            throw new IllegalArgumentException("입력한 숫자의 길이가 3이 아닙니다.");
        }

        for (char ch : input.toCharArray()) {
            if (!Character.isDigit(ch)) {
                throw new IllegalArgumentException("유효하지 않은 숫자가 포함되어 있습니다.");
            }
            numbers.add(Character.getNumericValue(ch));
        }

        return numbers;
    }
}
