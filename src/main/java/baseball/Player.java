package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class Player {
    public List<Integer> readNumber() {
        String read = Console.readLine().strip();
        validateCount(read);

        List<Integer> numbers = new ArrayList<>();
        for (char c: read.toCharArray()) {
            numbers.add(Character.getNumericValue(c));
        }
        return numbers;
    }

    private void validateCount(String numbers) {
        if (numbers.length() != 3) {
            throw new IllegalArgumentException("3개의 숫자만 입력해야 합니다.");
        }
    }
}
