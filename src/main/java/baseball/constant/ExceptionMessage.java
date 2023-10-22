package baseball.constant;

public enum ExceptionMessage {

    Requires3Digits("세자리 숫자를 입력해주세요"),
    RequiresUniqueElements("중복되지 않은 세자리 숫자를 입력해주세요"),
    RequiresOnlyNumberBetween1And9("1과 9 사이의 숫자만을 입력해주세요");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}