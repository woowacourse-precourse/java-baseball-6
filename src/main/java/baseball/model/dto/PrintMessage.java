package baseball.model.dto;

public enum PrintMessage {
    INPUT_NUMBER_MESSAGE("숫자를 입력해주세요 : "),
    INPUT_RESTART_NUMBER_MESSAGE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    GAME_END_MESSAGE("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"),
    GAME_START_MESSAGE("게임을 시작합니다.\n");

    final String message;

    PrintMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }

}
