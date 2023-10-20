package baseball.validator;

import java.util.HashSet;

public class Validator {
    public static void isValidNumbers(String numbers) {
        if(!isValidDigit(numbers)){
            throw new IllegalArgumentException("3자리가 아닙니다");
        }
        if (!isInteger(numbers)) {
            throw new IllegalArgumentException("입력한 값이 정수가 아닙니다.");
        }
        if (hasDuplicate(numbers)) {
            throw new IllegalArgumentException("입력한 값에 중복된 값이 있습니다.");
        }
        if (hasZero(numbers)) {
            throw new IllegalArgumentException("입력한 값에 0이 있습니다. 1~9의 숫자를 입력하세요.");
        }
    }

    /**
     *  입력된 값에 0이 있을 경우 isInteger()로 예외 처리가 안되므로
     *  hasZero()로 예외 처리를 해준다.
     */
    public static boolean hasZero(String numbers) {
        return numbers.contains("0");
    }
    public static boolean isValidDigit(String numbers) {
        return numbers.length() == 3;
    }

    public static boolean hasDuplicate(String numbers) {
        HashSet<Character> set = new HashSet<>();
        for (char ch : numbers.toCharArray()) {
            set.add(ch);
        }
        if (set.size() != numbers.length()) {
            return true;
        }
        return false;
    }

    public static boolean isInteger(String numbers) {
        try {
            Integer.parseInt(numbers);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void isValidGameOption(String input) {
        if (!(input.equals("1") || input.equals("2"))) {
            throw new IllegalArgumentException("게임 재시작은 1,종료는 2를 입력하세요. 잘못된 값이 입력되었습니다.");
        }
    }
}
