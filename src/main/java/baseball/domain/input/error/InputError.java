package baseball.domain.input.error;

public enum InputError {

    NEED_THREE_DIGIT("가 아닌 3자리의 숫자가 필요합니다."),

    MUST_BE_DIGIT("가 아닌 1에서 9 사이의 숫자로만 이루어져야 합니다."),

    NEED_NON_DUPLICATE_NUMBERS("가 아닌 중복되는 숫자가 없어야 합니다."),
    ;

    final String message;

    InputError(String message) {
        this.message = message;
    }
}
