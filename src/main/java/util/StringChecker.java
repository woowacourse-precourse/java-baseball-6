package util;

/**
 * description: 문자열을 검사하는 클래스
 */
public class StringChecker {
    /**
     * description: 문자열이 모두 숫자로 이루어져 있는지 확인하는 메소드
     *
     * @param input 문자열
     * @return 문자열이 모두 숫자로 이루어져 있으면 true, 아니면 false
     */
    public boolean isStringAllDigits(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * description: 문자열이 숫자로 이루어져 있고, 길이가 numberLength와 같은지 확인하는 메소드
     *
     * @param number       문자열
     * @param numberLength 문자열의 길이
     * @return 문자열이 숫자로 이루어져 있고, 길이가 numberLength와 같으면 true, 아니면 false
     */
    public boolean isValidNumberFormat(String number, int numberLength) {
        if (number.length() != numberLength || !this.isStringAllDigits(number)) {
            return false;
        }
        return true;
    }
}
