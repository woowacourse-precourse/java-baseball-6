package baseball.view;

import baseball.domain.Number;
import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.GameConstants.NUMBER_SIZE;

public class InputView {

    public static List<Number> readUserNumbers() {
        String input = Console.readLine();

        return parseToNumbers(input);
    }

    private static List<Number> parseToNumbers(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }

        List<Integer> numbers = input.chars()
                .map(Character::getNumericValue)
                .boxed()
                .toList();

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size() != NUMBER_SIZE.getNumber()) {
            throw new IllegalArgumentException("서로 다른 숫자 3개를 입력해주세요.");
        }
        return numbers.stream().map(Number::new).toList();
    }
}
