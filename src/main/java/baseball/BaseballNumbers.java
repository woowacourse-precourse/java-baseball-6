package baseball;

import baseball.io.Output;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class BaseballNumbers {

    private static final int MAX_LENGTH_OF_NUMBERS = 3;
    List<Integer> baseballNumbers;

    public BaseballNumbers() {
        Output.console("숫자를 입력해주세요 : ");
        String inputNumbersString = Console.readLine();

        if (inputNumbersString.length() != MAX_LENGTH_OF_NUMBERS) {
            throw new IllegalArgumentException("야구숫자는 세 자리여야 합니다.");
        }
        if (inputNumbersString.replaceAll("[0-9]", "").length() != 0) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
        if (inputNumbersString.length() != inputNumbersString.chars().distinct().count()) {
            throw new IllegalArgumentException("입력값은 중복되지 않아야 합니다.");
        }
        if (inputNumbersString.chars().mapToObj(Character::getNumericValue)
                .anyMatch(number -> number.compareTo(0) < 0)) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }

        this.baseballNumbers = inputNumbersString.chars()
                .mapToObj(Character::getNumericValue)
                .toList();
    }

    public List<Integer> getNumbers() {
        return baseballNumbers;
    }
}
