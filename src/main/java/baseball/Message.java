package baseball;

public enum Message {
    START("숫자 야구 게임을 시작합니다."),
    END("게임을 종료합니다."),
    INPUT("숫자를 입력해주세요: "),
    INPUT_ERROR("서로 다른 "+GameInfo.NUMBER_OF_DIGITS+"개의 숫자를 공백 없이 입력해 주세요."),
    NOTHING("낫싱"),
    WIN(GameInfo.NUMBER_OF_DIGITS+"개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    PROCESS("게임을 새로 시작하려면 "+GameInfo.GAME_RESTART_INPUT+", 종료하려면 "+GameInfo.GAME_END_INPUT+"를 입력하세요."),
    PROCESS_ERROR(GameInfo.GAME_RESTART_INPUT+" 또는 "+GameInfo.GAME_END_INPUT+"를 입력해 주세요.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
