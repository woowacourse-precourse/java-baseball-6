package baseball;

import static baseball.GameOption.BASEBALL_END_NUMBER;
import static baseball.GameOption.BASEBALL_SIZE;
import static baseball.GameOption.BASEBALL_START_NUMBER;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Validator {

    public List<Integer> validateBaseballNumber(String inputValue) {
        validateLength(inputValue, GameOption.BASEBALL_SIZE);
        List<Integer> result = new ArrayList<>();
        IntStream.range(0, inputValue.length())
                .forEach(i -> {
                    String substring = inputValue.substring(i, i + 1);
                    validateNumber(substring);
                    result.add(Integer.parseInt(substring));
                });
        validateSameNumber(result);
        return result;
    }

    public int validatedRestart(String inputValue) {
        validateLength(inputValue, 1);
        validateNumber(inputValue);
        if (!"12".contains(inputValue)) {
            throw new IllegalArgumentException("1과 2만 입력할 수 있습니다.");
        }
        return Integer.parseInt(inputValue);
    }

    private static void validateLength(String value, int size) {
        if (value.length() != size) {
            throw new IllegalArgumentException(GameOption.BASEBALL_SIZE + "자리 숫자를 입력해야 합니다.");
        }
    }

    private static void validateNumber(String value) {
        value.chars()
                .forEach((currentChar) -> {
                    if (isOutOfRange((char) currentChar)) {
                        throw new IllegalArgumentException(
                                BASEBALL_START_NUMBER + "에서 " +
                                        BASEBALL_END_NUMBER + "까지 서로 다른 임의의 수 " +
                                        BASEBALL_SIZE + "개를 선택해야합니다.");
                    }
                });
    }

    private static boolean isOutOfRange(char currentChar) {
        return currentChar < BASEBALL_START_NUMBER + '0' || currentChar > BASEBALL_END_NUMBER + '0';
    }

    private static void validateSameNumber(List<Integer> value) {
        int count = (int) value.stream()
                .distinct()
                .count();
        if (count != GameOption.BASEBALL_SIZE) {
            throw new IllegalArgumentException("중복된 숫자가 포함되어 있습니다.");
        }
    }

}
