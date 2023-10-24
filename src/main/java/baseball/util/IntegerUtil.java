package baseball.util;

public class IntegerUtil {

    private static final String INVALID_INTEGER_MESSAGE = "이 값은 정수로 변환할 수 없습니다.";

    public static boolean isInteger(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static void validateInteger(String string) {
        if (!isInteger(string)) {
            ExceptionUtil.throwInvalidValueException(INVALID_INTEGER_MESSAGE);
        }
    }

    public static boolean isSame(Integer i1,Integer i2) {
        return ObjectUtil.isSame(i1,i2);
    }

    public static Integer parseInteger(char character){
        Integer integer = character - '0';

        return integer;
    }
}
