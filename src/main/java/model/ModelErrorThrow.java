package model;

/**
 * ModelErrorThrow.java
 * <p>
 * 예외처리 관련 모델
 *
 * @author Lee NaYeon
 * @since 2023-10-25
 */

public class ModelErrorThrow {

    /**
     * 예외 던지기
     *
     * @param str 예외 이유
     */
    public static void errorThrow(String str) {

        String message = setMessage(str);

        throw new IllegalArgumentException(message);
    }

    /**
     * 예외 이유에 따른 메세지 설정
     *
     * @param str 예외 이유
     * @return 메세지
     */
    private static String setMessage(String str) {
        return switch (str) {
            case "notNum" -> "숫자를 입력해 주세요";
            case "wrongLen" -> "3자리 숫자가 아닙니다.";
            case "duplicate" -> "중복된 숫자가 존재합니다.";
            case "invalidNum" -> "유효한 숫자가 아닙니다.";
            default -> "";
        };
    }
}

