package baseball.validators;

public class NumberValidator {

    public static void validateNumber(String numbers) {
        validateOutOfRange(numbers);
        validateInputSize(numbers);
        validateDuplicates(numbers);
    }

    private static void validateOutOfRange(String numbers) {
        boolean allMatch = numbers.chars().allMatch(c -> c >= '1' && c <= '9');
        if (!allMatch) {
            throw new IllegalArgumentException("1과 9 사이의 숫자를 입력해주세요.");
        }
    }

    private static void validateInputSize(String numbers) {
        if (numbers.length() != 3) {
            throw new IllegalArgumentException("3개의 숫자만 입력할 수 있습니다.");
        }
    }

    private static void validateDuplicates(String numbers) {
        if (numbers.chars().distinct().count() != numbers.length()) {
            throw new IllegalArgumentException("중복 없이 숫자를 입력해주세요.");
        }
    }
}
