package baseball.util;

import baseball.ball.Balls;
import baseball.ball.Number;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {
    public static final Set<String> AFTER_GAME_COMMAND = Set.of("1", "2");

    public void validateDigits(String input) {
        boolean isNumber = input.chars().allMatch(Character::isDigit);

        if (!isNumber) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다.");
        }
    }

    public void validateDuplicate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);

        if(set.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복이 존재합니다.");
        }
    }

    public void validateInputSize(List<Integer> numbers) {
        if (numbers.size() != Balls.BALLS_SIZE) {
            throw new IllegalArgumentException("[ERROR] 3 자리 수를 입력해야 합니다.");
        }
    }

    public void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < Number.MINIMUM_NUMBER || Number.MAXIMUM_NUMBER < number) {
                throw new IllegalArgumentException("[ERROR] 1-9 까지의 수만 입력해야 합니다.");
            }
        }
    }

    public void validateCommandAfterGame(String command) {
        if (!AFTER_GAME_COMMAND.contains(command)) {
            throw new IllegalArgumentException("[ERROR] 1 또는 2 만 입력할 수 있습니다.");
        }
    }
}
