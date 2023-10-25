package constant;

public enum ErrorMessage {
    INVALID_RESTART_INFO_LENGTH(
            "잘못된 입력입니다. 게임을 다시 시작하시려면 " + Constant.RESTART_VALUE.getValue() + ", 끝내시려면 "
                    + Constant.FINISH_GAME_VALUE.getValue()
                    + "를 입력해주세요."),
    INVALID_RESTART_INFO_TYPE(
            "게임 재시작 여부는 " + Constant.RESTART_VALUE.getValue() + " 또는 " + Constant.FINISH_GAME_VALUE.getValue()
                    + "의 숫자를 입력해주세요."),
    INVALID_RESTART_INFO_VALUE(
            "게임을 다시 시작하시려면 " + Constant.RESTART_VALUE.getValue() + ", 끝내시려면 " + Constant.FINISH_GAME_VALUE
                    + "를 입력해주세요."),
    INVALID_PLAYER_INPUT_LENGTH("잘못된 입력입니다. " + Constant.BASEBALL_GAME_NUMBER_LENGTH.getValue() + "자리의 숫자를 입력해주세요."),
    INVALID_PLAYER_INPUT_TYPE(Constant.BASEBALL_GAME_NUMBER_LENGTH.getValue() + "자리 숫자만 입력해주세요."),
    INVALID_PLAYER_INPUT_ZERO(
            Constant.ZERO.getValue() + "을 제외한 " + Constant.BASEBALL_GAME_NUMBER_RANGE_START_VALUE.getValue() + "부터 "
                    + Constant.BASEBALL_GAME_NUMBER_RANGE_LAST_VALUE.getValue() + "까지의 수로 이루어진 "
                    + Constant.BASEBALL_GAME_NUMBER_LENGTH.getValue() + "자리 숫자를 입력해주세요."),
    INVALID_PLAYER_INPUT_DUPLICATION(
            "중복되지 않는 숫자 " + Constant.BASEBALL_GAME_NUMBER_LENGTH.getValue() + "개를 이용하여 세 자리 숫자를 입력해주세요.");

    private String message;

    private ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
