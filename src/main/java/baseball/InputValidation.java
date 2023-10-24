package baseball;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class InputValidation {
    public void validatePlayerInput(String input) throws IllegalArgumentException {
        validateInputValue(input);
        validateThreeEachNumber(input);
    }

    public void validateInputValue(String input) throws IllegalArgumentException {
        if (input.contains(" ")) {
            throw new IllegalArgumentException("공백 없이 오직 숫자만 입력해주시기 바랍니다.");
        }
        if (input.contains(",")) {
            throw new IllegalArgumentException("콤마 없이 오직 숫자만 입력해주시기 바랍니다.");
        }
        if (input.length() != 3) {
            throw new IllegalArgumentException("3개의 숫자만을 입력해주시기 바랍니다.");
        }
    }

    public void validateThreeEachNumber(String input) throws IllegalArgumentException {
        Set<Character> charSet = input.chars().mapToObj(c -> (char)c).collect(Collectors.toSet());

        if (charSet.size() != 3) {
            throw new IllegalArgumentException("숫자를 중복하지 않고 입력해주시기 바랍니다.");
        }

        charSet.forEach(c -> {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("숫자만을 입력해주시기 바랍니다.");
            }
            if (c.equals('0')) {
                throw new IllegalArgumentException("1 ~ 9 사이의 숫자만을 입력해주시기 바랍니다.");
            }
        });
    }

    public int validateGameEndRequestInput(String input) throws IllegalArgumentException {
        if (input.length() != 1) {
            throw new IllegalArgumentException("한자리 숫자 입력해주세요.");
        }
        if (!Character.isDigit(input.charAt(0))) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }

        int inputValue = Character.getNumericValue(input.charAt(0));

        if (inputValue < 1 || inputValue > 2) {
            throw new IllegalArgumentException("1 혹은 2를 입력해주세요.");
        }

        return inputValue;
    }

    public List<Integer> convertPlayerInput(String playerInput) {
        final List<Integer> convertedInput = playerInput.chars()
                .mapToObj(c -> Character.getNumericValue((char) c))
                .collect(Collectors.toList());

        return convertedInput;
    }
}
