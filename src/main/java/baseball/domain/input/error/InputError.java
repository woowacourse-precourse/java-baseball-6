package baseball.domain.input.error;

public enum InputError {
    
    NEED_THREE_DIGIT("3자리의 숫자가 필요합니다."),

    MUST_BE_DIGIT("문자가 아닌 숫자로만 이루어져야 합니다.")
    ;

    final String message;

    InputError(String message) {
        this.message = message;
    }
}
