package baseball.enums;

public enum Message {

    NON_NUMERIC_ERROR_MESSAGE("숫자만 입력해주세요."),
    LENGTH_ERROR_MESSAGE("입력 길이가 일치하지 않습니다 입력 길이는 : "),
    DUPLICATE_ERROR_MESSAGE("중복된 숫자가 포함되어 있습니다."),
    GAME_COMMAND_ERROR_MESSAGE("올바른 명령이 아닙니다."),
    GAME_START_MESSAGE("숫자 야구 게임을 시작합니다."),
    GAME_INPUT_NUMBER_MESSAGE("숫자를 입력해주세요 : "),
    GAME_FINISHED_MESSAGE("개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    GAME_RESTART_OR_END_MESSAGE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    private String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
