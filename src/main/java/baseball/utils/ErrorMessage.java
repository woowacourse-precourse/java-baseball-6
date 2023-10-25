package baseball.utils;

public class ErrorMessage {
    private static String ERROR_TAG = "[ERROR] ";

    public static String NUMBERS_NOT_POSITIVE_INTEGER = ERROR_TAG + "0보다 큰 정수만 가능합니다.\n";
    public static String NUMBERS_SIZE_IS_INVALID = ERROR_TAG + "3개의 숫자만 가능합니다.\n";
    public static String NUMBERS_OUT_OF_RANGE = ERROR_TAG + "1~9까지 3개의 숫자를 공백 없이 나열해주세요.\n";
    public static String NUMBERS_DUPLICATED = ERROR_TAG + "서로 다른 숫자만 가능합니다.\n";
    public static String COMMAND_CODE_IS_INVALID = ERROR_TAG + "1 혹은 2 숫자만 가능합니다.\n";
}
