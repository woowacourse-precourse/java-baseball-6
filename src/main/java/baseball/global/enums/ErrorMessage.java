package baseball.global.enums;

/**
 * 비정상적인 상황에 대해 커스텀한 예외 메시지와 함께 IllegalArgumentException을 던져서 예외처리
 */
public enum ErrorMessage {

    EMPTY_INPUT_VALUE("입력값이 비어 있습니다."),
    INVALID_MENU_CHOICE("1(재시작) 또는 2(종료)만 입력해주세요."),
    INVALID_INPUT_VALUE("유효하지 않은 입력값입니다."),
    NO_ZERO_IN_NUM("0은 숫자에 포함할 수 없습니다."),
    DIFFERENT_THREE_DIGITS("서로 다른 세 자리 수를 입력하세요.");

    public final String message;

    ErrorMessage(String message) {
        this.message = message;
    }
}
