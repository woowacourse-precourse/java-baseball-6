package baseball.util;

public enum Sentence {
    GAME_START_MESSAGE("숫자 야구 게임을 시작합니다."),
    INPUT_NUMBER_MESSAGE("숫자를 입력해주세요 : "),
    GAME_SUCCESS_MESSAGE("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    GAME_RESTART_EXIT_MESSAGE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    ERROR_NUMBERS_DUPLICATION_MESSAGE("[ERROR] 서로 다른 숫자를 입력해주세요."),
    ERROR_NOT_THREE_SIZE_MESSAGE("[ERROR] 3자리의 숫자를 입력해주세요."),
    ERROR_GAME_ACTION_INPUT_MESSAGE("[ERROR] 게임 재실행 또는 종료에 대한 입력 값은 1 또는 2만 가능합니다."),
    ERROR_INPUT_NOT_NUMBERS_MESSAGE("[ERROR] 숫자만 입력할 수 있습니다.");

    private final String message;

    Sentence(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
