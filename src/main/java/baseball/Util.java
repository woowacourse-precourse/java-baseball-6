package baseball;

public class Util {
    public static void handleException(String input) {
        if (isOverMaxLength(input)) {
            throw new IllegalArgumentException("최대 길이 " + Constant.MAX_NUMBER_SIZE + "를 넘어가는 입력입니다.");
        } else if (isInValidInput(input)) {
            throw new IllegalArgumentException("올바른 입력이 아닙니다. 정수를 입력해야합니다.");
        } else if (isDuplicate(input)) {
            throw new IllegalArgumentException("입력한 숫자가 중복됩니다.");
        }
    }

    public static boolean isOverMaxLength(String input) {
        return input.length() > Constant.MAX_NUMBER_SIZE;
    }

    public static boolean isInValidInput(String input) {
        try {
            Integer.parseInt(input);
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    public static boolean isDuplicate(String input) {
        return input.chars().distinct().count() != input.length();
    }

    public static int[] stringToIntArray(String str) {
        return str.chars().map(i -> i - '0').toArray();
    }
}
