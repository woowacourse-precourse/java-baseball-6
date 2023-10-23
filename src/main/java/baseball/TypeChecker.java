package baseball;

public class TypeChecker {
    // 정수인지 확인하는 메서드
    public static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
