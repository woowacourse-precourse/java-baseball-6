package baseball.util;

public enum ErrorMessage {
    INVALID_RESTART_INPUT("게임을 재시작하려면 1, 종료하려면 2를 입력해야합니다."),
    PLAYER_INPUT_NUMBER_DUPLICATE_NUMBER("입력 값에 중복된 값이 포함되어있습니다."),
    PLAYER_INPUT_NUMBER_NOT_A_NUMBER("입력 값이 숫자가 아닙니다."),
    PLAYER_INPUT_NUMBER_NOT_3_DIGIT("입력 값이 3자리가 아닙니다."),
    PLAYER_INPUT_NUMBER_NOT_GIVEN_RANGE("1부터 9까지의 숫자를 입력해야합니다."),
    ;
    final String message;

    ErrorMessage(String message) {
        this.message = message;
    }
}
