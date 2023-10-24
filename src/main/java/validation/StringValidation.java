package validation;

public class StringValidation {

    private StringValidation() {
    }

    // 문자열에 중복되는 문자가 존재하는지 확인하는 함수
    public static void validateDuplication(final String str) {
        // 중복되는 문자가 존재하면 true 리턴
        for (int i = 0; i < str.length(); i++) {
            if (str.indexOf(str.charAt(i)) != i) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void validateLength(final String str, final int length) {
        if (str.length() > length) {
            throw new IllegalArgumentException();
        }
    }

    // 문자열이 Integer 인지 확인 후 맞으면 int 형으로 반환
    public static int validateInteger(final String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
