package baseball.collaborator.number.generator;

import baseball.io.Input;
import baseball.io.Output;
import java.util.List;

public class BaseballNumbersGenerator implements NumbersGenerator {

    @Override
    public List<Integer> generate() {
        Output.console("숫자를 입력해주세요 : ");
        List<Integer> numbers = Input.consoleNumbers();
        validation(numbers);
        return numbers;
    }

    private static void validation(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException("야구숫자는 세 자리여야 합니다.");
        }
        if (numbers.stream().distinct().count() != NUMBERS_SIZE) {
            throw new IllegalArgumentException("입력값은 중복되지 않아야 합니다.");
        }
        if (numbers.stream().anyMatch(number -> number.compareTo(0) < 0)) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
    }

}
