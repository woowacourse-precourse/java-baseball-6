package baseball.view;

import static baseball.config.BaseBallGameConfig.BASEBALL_NUMBER_SIZE;

public enum ConsoleMessage {

    GAME_START("숫자 야구 게임을 시작합니다. \n"),
    ENTER_NUMBER("숫자를 입력해주세요 : "),
    CORRECT_ANSWER(String.format("%d개의 숫자를 모두 맞히셨습니다! 게임 종료%n", BASEBALL_NUMBER_SIZE.getValue())),
    RESTART("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");

    private final String message;

    ConsoleMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
