package baseball.util;

public class Validation {

    public final static int MAX_INPUT_LENGTH = 3;
    private final static int MAX_EXIT_INPUT_LENGTH = 1;

    private static boolean containsZero(String number) {
        return number.contains("0");
    }

    public static void validNumber(String number) {

        if (containsZero(number)) {
            throw new IllegalArgumentException("입력 문자열에 0이 포함되었습니다.");
        } else if (validLength(number, MAX_INPUT_LENGTH)) {
            throw new IllegalArgumentException("입력 문자열의 길이가 3이 되어야 합니다.");
        } else if (containsLetter(number, MAX_INPUT_LENGTH)) {
            throw new IllegalArgumentException("입력 문자열은 숫자이어야 합니다.");
        } else if (duplicateNumber(number)) {
            throw new IllegalArgumentException("입력 문자열은 서로 다른 3자리 수이어야 합니다.");
        }
    }

    public static void validExitNumber(String number) {

        if (validLength(number, MAX_EXIT_INPUT_LENGTH)) {
            throw new IllegalArgumentException("입력 문자열의 길이가 1이 되어야 합니다.");
        } else if (containsLetter(number, MAX_EXIT_INPUT_LENGTH)) {
            throw new IllegalArgumentException("입력 문자열은 숫자이어야 합니다.");
        } else if (!isOneOrTwo(number)) {
            throw new IllegalArgumentException("입력 문자열이 1 또는 2가 아닙니다.");
        }
    }

    private static boolean containsLetter(String number, int maxLength) {
        String tmp = number.replaceAll("[^1-9]", "");

        return tmp.length() < maxLength;
    }

    private static boolean validLength(String number, int maxLength) {
        return number.length() != maxLength;
    }

    private static boolean duplicateNumber(String number) {
        int[] nums = new int[10];

        for (int i = 0; i < number.length(); i++) {
            int num = Character.getNumericValue(number.charAt(i));
            nums[num]++;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 1) {
                return true;
            }
        }

        return false;
    }

    private static boolean isOneOrTwo(String number) {
        return number.equals("1") || number.equals("2");
    }
}
