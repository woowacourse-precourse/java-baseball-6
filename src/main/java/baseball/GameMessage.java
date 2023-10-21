package baseball;

public enum GameMessage {
    WELCOME_MESSAGE("숫자 야구 게임을 시작합니다.\n"),
    WIN_MESSAGE("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"),
    GAME_RESTART_PROMPT("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n"),
    INPUT_PROMPT("숫자를 입력해주세요 : ");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    void print() {
        System.out.print(message);
    }
}
