package baseball.object.number.generator;

import baseball.io.Input;
import baseball.io.Output;
import java.util.List;

public class BaseballNumbersGenerator implements NumbersGenerator {

    @Override
    public List<Integer> generate() {
        Output.console("숫자를 입력해주세요 : ");
        String inputNumbersString = Input.consoleLine();

        if (inputNumbersString.length() != MAX_SIZE) {
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

        return inputNumbersString.chars()
                .mapToObj(Character::getNumericValue)
                .toList();
    }
}
