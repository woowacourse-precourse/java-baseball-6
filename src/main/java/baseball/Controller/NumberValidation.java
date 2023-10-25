package baseball.Controller;

/*
판단 메소드 생성
# 1~9 사이의 숫자 사용
=> 반복문을 사용하여 숫자 비교
# 3자리수
=> 길이 비교
# 중복되지 않은 수 사용
=> 반복문을 통해 비교
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberValidation {

    public List<Integer> validationNumber(String inputNumber) {
        try {
            if (!checkBetween1to9(inputNumber)) {
                throw new IllegalArgumentException("1~9 사이의 수만 입력이 가능합니다.");
            } else if (!threeDigit(inputNumber)) {
                throw new IllegalArgumentException("3자리의 수를 입력해야 합니다.");
            } else if (!checkDuplication(inputNumber)) {
                throw new IllegalArgumentException("중복된 수를 사용할 수 없습니다.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Validation Error: " + e.getMessage());
            return Collections.emptyList(); // Return an empty list in case of validation error.
        }

        return toInputNumber(inputNumber);
    }

    public List<Integer> toInputNumber(String inputNumber) {
        int[] cvtIntArray;
        try {
            cvtIntArray = Stream.of(inputNumber.split("")).mapToInt(Integer::parseInt).toArray();
        } catch (NumberFormatException e) {
            System.out.println("Conversion Error: " + e.getMessage());
            return Collections.emptyList(); // Return an empty list in case of conversion error.
        }
        return Arrays.stream(cvtIntArray).boxed().collect(Collectors.toList());
    }

    private boolean between1to9(char checkNum) {
        return checkNum >= '1' && checkNum <= '9';
    }

    public boolean threeDigit(String inputNumber) {
        return inputNumber.length() == 3;
    }

    public boolean checkDuplication(String inputNumber) {
        String[] number = inputNumber.split("");
        Set<String> setNums = Arrays.stream(number).collect(Collectors.toSet());

        return setNums.size() == 3;
    }

    public boolean checkBetween1to9(String inputNumber) {
        for (int i = 0; i < inputNumber.length(); i++) {
            if (!between1to9(inputNumber.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NumberValidation validator = new NumberValidation();

        // Example usage:
        List<Integer> validNumbers = validator.validationNumber("123");
        if (!validNumbers.isEmpty()) {
            System.out.println("Valid Numbers: " + validNumbers);
        }
    }
}
