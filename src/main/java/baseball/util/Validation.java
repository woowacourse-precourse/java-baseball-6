package baseball.util;

public class Validation {

    public final static int MAX_INPUT_LENGTH = 3;
    private final static int MAX_EXIT_INPUT_LENGTH = 1;

    public static void validNumber(String number) {
        containsZero(number);
        validLength(number, MAX_INPUT_LENGTH);
        containsLetter(number, MAX_INPUT_LENGTH);
        duplicateNumber(number);
    }

    public static void validExitNumber(String number) {
        validLength(number, MAX_EXIT_INPUT_LENGTH);
        containsLetter(number, MAX_EXIT_INPUT_LENGTH);
        isOneOrTwo(number);
    }

    private static void containsZero(String number) {
        if (number.contains("0")) {
            throw new IllegalArgumentException("입력 문자열에 0이 포함되었습니다.");
        }
    }

    private static void containsLetter(String number, int maxLength) {
        String removedNumberString = number.replaceAll("[^1-9]", "");
        int numberLength = removedNumberString.length();

        if (numberLength < maxLength) {
            throw new IllegalArgumentException("입력 문자열은 숫자이어야 합니다.");
        }
    }

    private static void validLength(String number, int maxLength) {
        int numberLength = number.length();

        if (numberLength != maxLength) {
            throw new IllegalArgumentException("입력 문자열의 길이가 " + maxLength + "이 되어야 합니다.");
        }
    }

    private static void duplicateNumber(String number) {
        int[] nums = new int[10];

        for (int i = 0; i < number.length(); i++) {
            int num = Character.getNumericValue(number.charAt(i));
            nums[num]++;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 1) {
                throw new IllegalArgumentException("입력 문자열은 서로 다른 3자리 수이어야 합니다.");
            }
        }
    }

    private static void isOneOrTwo(String number) {
        String replacedString = number.replaceAll("[1-2]", "");
        int length = replacedString.length();

        if (length > 0) {
            throw new IllegalArgumentException("입력 문자열이 1 또는 2가 아닙니다.");
        }
    }
}
