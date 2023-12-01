package baseball;

public enum ErrorMessage {
    NUMBERS_OVERSIZE("입력하신 숫자는 3자리가 넘어갑니다. 3자리 숫자를 입력해주세요."),
    NUMBERS_UNDERSIZE("입력하신 숫자는 3자리가 안됩니다. 3자리 숫자를 입력해주세요."),
    INCLUDE_INVALID_NUMBER("0은 입력할 수 없습니다. 1~9 숫자를 입력해주세요."),
    INCLUDE_DUPLICATE_NUMBER("중복된 입력이 있습니다. 서로 다른 3자리 수를 입력해주세요."),
    INCLUDE_NOT_NUMBER("정수만 입력해주세요");

    String message;

    public String getMessage() {
        return message;
    }

    ErrorMessage(String message) {
        this.message = message;
    }
}
