package baseball.util;

public enum MessageEnum {

    START_MESSAGE("숫자 야구 게임을 시작합니다."),
    INPUT_START_MESSAGE("숫자를 입력해주세요 : "),
    SUCCESS_MESSAGE("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

    private final String message;

    MessageEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
