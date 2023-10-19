package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputView {

    public static List<Integer> readUserNumbers() {
        String input = Console.readLine();

        return parseToNumbers(input);
    }

    private static List<Integer> parseToNumbers(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }

        List<Integer> numbers = input.chars()
                .map(Character::getNumericValue)
                .boxed()
                .toList();

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size() != 3) {
            throw new IllegalArgumentException("서로 다른 숫자 3개를 입력해주세요.");
        }

        if (numbers.stream().anyMatch(number -> number < 1 || number > 9)) {
            throw new IllegalArgumentException("각 자릿수는 1~9 사이의 숫자만 가능합니다.");
        }
        return numbers;
    }
}
