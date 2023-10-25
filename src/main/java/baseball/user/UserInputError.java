package baseball.user;

public enum UserInputError {
    INVALID_LENGTH("올바른 숫자 3가지를 입력해주세요."),
    DUPLICATED_NUMBER("중복된 숫자가 있습니다."),
    OUT_OF_RANGE("1부터 9사이의 숫자만 입력해주세요"),
    INVALID_QUIT_OR_CONTINUE_OPTION("1번 혹은 2번을 입력하세요.");


    private final String message;

    UserInputError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
