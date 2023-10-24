package baseball.constant;

import java.util.List;

public enum GameMessage {

    STRIKE("%d스트라이크\n"),
    BALL("%d볼\n"),
    BALL_STRIKE("%d볼 %d스트라이크\n"),
    NOTHING("낫싱\n"),
    THREE_STRIKE("%d개의 숫자를 모두 맞히셨습니다! 게임 종료\n"),
    ASK_REPLAY("게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.\n");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
