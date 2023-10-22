package baseball;

import java.util.List;

public class Validator {

    public List<Integer> validatedBaseballNumber(String inputValue) {
        validateLength(inputValue, GameOption.BASEBALL_SIZE);
        List<String> stringBaseballNumber = Utils.divideByOneLatter(inputValue);
        List<Integer> baseballNumber = Utils.stringListToIntList(stringBaseballNumber);
        validateListInRange(baseballNumber, GameOption.BASEBALL_START_NUMBER, GameOption.BASEBALL_END_NUMBER);
        validateSameNumber(baseballNumber);
        return baseballNumber;
    }

    private void validateListInRange(List<Integer> list, int start, int end) {
        list.forEach(number -> validateInRange(number, start, end));
    }

    private void validateInRange(int number, int start, int end) {
        if (!Utils.isInRange(number, start, end)) {
            throw new IllegalArgumentException("허용되지 않는 값입니다. " + number);
        }
    }

    public int validatedRestart(String inputValue) {
        validateLength(inputValue, 1);
        int intValue = Integer.parseInt(inputValue);
        validateInRange(intValue, 1, 2);
        return intValue;
    }

    private static void validateLength(String value, int size) {
        if (value.length() != size) {
            throw new IllegalArgumentException(GameOption.BASEBALL_SIZE + "자리 숫자를 입력해야 합니다.");
        }
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
