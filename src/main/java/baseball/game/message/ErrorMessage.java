package baseball.game.message;

public enum ErrorMessage {
    BLANK_INPUT("입력은 반드시 주어져야 합니다."),
    INVALID_LENGTH("적절하지 않은 숫자 값입니다."),
    NOT_DIGIT("입력이 숫자가 아닙니다."),
    INVALID_MENU("부적절한 메뉴 입력입니다."),
    INVALID_SCORE("부적절한 점수입니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
